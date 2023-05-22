package legend.game.input;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import legend.core.opengl.Window;
import legend.game.modding.coremod.CoreMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import javax.annotation.Nullable;

import static legend.core.GameEngine.CONFIG;
import static legend.core.GameEngine.GPU;
import static legend.game.Scus94491BpeSegment.keyRepeat;
import static legend.game.Scus94491BpeSegment_800b.analogAngle_800bee9c;
import static legend.game.Scus94491BpeSegment_800b.analogInput_800beebc;
import static legend.game.Scus94491BpeSegment_800b.analogMagnitude_800beeb4;
import static legend.game.Scus94491BpeSegment_800b.input_800bee90;
import static legend.game.Scus94491BpeSegment_800b.press_800bee94;
import static legend.game.Scus94491BpeSegment_800b.repeat_800bee98;
import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_AXIS_LEFT_X;
import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_AXIS_LEFT_Y;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_C;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Z;

public final class Input {
  private static final Logger LOGGER = LogManager.getFormatterLogger();
  private static final Marker INPUT_MARKER = MarkerManager.getMarker("INPUT");

  public static final ControllerManager controllerManager = new ControllerManager(Input::onControllerConnected, Input::onControllerDisconnected);
  private static Controller playerOne;

  private static final Object2BooleanMap<InputBinding> held = new Object2BooleanOpenHashMap<>();
  private static final Object2BooleanMap<InputBinding> pressedThisFrame = new Object2BooleanOpenHashMap<>();

  private Input() {
  }

  public static void update() {
    if(!GPU.window().hasFocus() && !CONFIG.getConfig(CoreMod.RECEIVE_INPUT_ON_INACTIVE_WINDOW_CONFIG.get()) || playerOne == null) {
      return;
    }

    playerOne.poll();

    for(final InputBinding binding : playerOne.bindings) {
      if(binding.getState().pressed) {
        if(!held.containsKey(binding)) {
          pressedThisFrame.put(binding, true);
          held.put(binding, true);
        }
      } else if(held.containsKey(binding)) {
        held.removeBoolean(binding);
        keyRepeat.remove(binding.getInputAction().hexCode);
      }
    }

    InputPlayerUtility.update();

    GPU.window().events.callInputEvents(playerOne);
  }

  public static void updateLegacyInput() {
    input_800bee90.set(0);
    analogAngle_800bee9c.set(0);
    analogMagnitude_800beeb4.set(0);

    for(final var entry : held.object2BooleanEntrySet()) {
      if(entry.getBooleanValue()) {
        final InputAction inputAction = entry.getKey().getInputAction();

        if(inputAction.hexCode != -1) {
          input_800bee90.or(inputAction.hexCode);
        }

        if(inputAction == InputAction.JOYSTICK_LEFT_X || inputAction == InputAction.JOYSTICK_LEFT_Y) {
          final float x = playerOne.readAxis(GLFW_GAMEPAD_AXIS_LEFT_X);
          final float y = playerOne.readAxis(GLFW_GAMEPAD_AXIS_LEFT_Y);

          // Map discrete axis values (-1.0..1.0) to angle and magnitude that LOD expects
          final int angle = Math.floorMod((int)(Math.atan2(y, x) * 0x800 / Math.PI) + 0x400, 0x1000); // 0..0x1000, clockwise, up=0
          final int mag = (int)(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 0xff); // 0..0xff

          analogInput_800beebc.set(1);
          analogAngle_800bee9c.set(angle);
          analogMagnitude_800beeb4.set(mag);
        }
      }
    }

    for(final var entry : pressedThisFrame.object2BooleanEntrySet()) {
      final int hexCode = entry.getKey().getInputAction().hexCode;

      if(hexCode != -1) {
        if(entry.getBooleanValue()) {
          input_800bee90.or(hexCode);
          press_800bee94.or(hexCode);
          repeat_800bee98.or(hexCode);
          keyRepeat.put(hexCode, 0);
        } else {
          input_800bee90.and(~hexCode);
          press_800bee94.and(~hexCode);
          repeat_800bee98.and(~hexCode);
          keyRepeat.remove(hexCode);
        }
      }
    }
  }

  public static void clearLegacyInput() {
    pressedThisFrame.clear();
  }

  public static void init() {
    GPU.window().events.onKeyPress(Input::keyPress);
    GPU.window().events.onKeyRelease(Input::keyRelease);
    GPU.window().events.onLostFocus(Input::lostFocus);

    useController(null);

    controllerManager.init();
  }

  public static boolean pressedThisFrame(final InputAction targetKey) {
    for(final var entry : pressedThisFrame.object2BooleanEntrySet()) {
      if(entry.getKey().getInputAction() == targetKey) {
        return entry.getBooleanValue();
      }
    }

    return false;
  }

  public static boolean pressedWithRepeatPulse(final InputAction targetKey) {
    for(final InputBinding inputBinding : playerOne.bindings) {
      if(inputBinding.getInputAction() == targetKey) {
        if(inputBinding.getState() == InputState.PRESSED_THIS_FRAME || inputBinding.getState() == InputState.PRESSED_REPEAT) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean getButtonState(final InputAction targetInput) {
    for(final InputBinding inputBinding : playerOne.bindings) {
      if(inputBinding.getInputAction() == targetInput) {
        if(inputBinding.getState().pressed) {
          return true;
        }
      }
    }

    return false;
  }

  private static void keyPress(final Window window, final int key, final int scancode, final int mods) {
    if(mods != 0) {
      return;
    }

    for(final InputBinding inputBinding : playerOne.bindings) {
      if(inputBinding.getInputType() == InputType.KEYBOARD && inputBinding.getGlfwKeyCode() == key) {
        inputBinding.setPressedForKeyboardInput();
      }
    }
  }

  private static void keyRelease(final Window window, final int key, final int scancode, final int mods) {
    if(mods != 0) {
      return;
    }

    for(final InputBinding inputBinding : playerOne.bindings) {
      if(inputBinding.getInputType() == InputType.KEYBOARD && inputBinding.getGlfwKeyCode() == key) {
        inputBinding.setReleasedForKeyboardInput();
      }
    }
  }

  private static void lostFocus(final Window window) {
    for(final InputBinding inputBinding : playerOne.bindings) {
      inputBinding.release();
    }
  }

  public static void useController(@Nullable final Controller controller) {
    if(controller != null) {
      playerOne = controller;
    } else {
      playerOne = new DummyController();
      addKeyboardBindings(playerOne);
    }
  }

  private static void onControllerConnected(final GlfwController controller) {
    addKeyboardBindings(controller);

    if(playerOne.equals(controller)) {
      LOGGER.info(INPUT_MARKER,"Player 1 has been reconnected");
    }
  }

  private static void onControllerDisconnected(final GlfwController controller) {
    if(playerOne.equals(controller)) {
      LOGGER.info(INPUT_MARKER, "Player 1's controller has been disconnected. Please reconnect the controller, or switch to a different controller using F9.");
    }
  }

  private static void addKeyboardBindings(final Controller controller) {
    controller.addBinding(new InputBinding(InputAction.BUTTON_CENTER_1, controller, GLFW_KEY_SPACE, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_THUMB_1, controller, GLFW_KEY_Z, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_THUMB_2, controller, GLFW_KEY_C, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_CENTER_2, controller, GLFW_KEY_ENTER, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.DPAD_UP, controller, GLFW_KEY_UP, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.DPAD_RIGHT, controller, GLFW_KEY_RIGHT, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.DPAD_DOWN, controller, GLFW_KEY_DOWN, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.DPAD_LEFT, controller, GLFW_KEY_LEFT, InputType.KEYBOARD));

    controller.addBinding(new InputBinding(InputAction.BUTTON_SHOULDER_LEFT_2, controller, GLFW_KEY_1, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_SHOULDER_RIGHT_2, controller, GLFW_KEY_3, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_SHOULDER_LEFT_1, controller, GLFW_KEY_Q, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_SHOULDER_RIGHT_1, controller, GLFW_KEY_E, InputType.KEYBOARD));

    controller.addBinding(new InputBinding(InputAction.BUTTON_NORTH, controller, GLFW_KEY_W, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_EAST, controller, GLFW_KEY_D, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_SOUTH, controller, GLFW_KEY_S, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_WEST, controller, GLFW_KEY_A, InputType.KEYBOARD));

    controller.addBinding(new InputBinding(InputAction.BUTTON_EAST, controller, GLFW_KEY_ESCAPE, InputType.KEYBOARD));
    controller.addBinding(new InputBinding(InputAction.BUTTON_SOUTH, controller, GLFW_KEY_ENTER, InputType.KEYBOARD));
  }}
