package legend.core.opengl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11C.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11C.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11C.GL_CW;
import static org.lwjgl.opengl.GL11C.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11C.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11C.GL_VENDOR;
import static org.lwjgl.opengl.GL11C.GL_VERSION;
import static org.lwjgl.opengl.GL11C.glClear;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.opengl.GL11C.glEnable;
import static org.lwjgl.opengl.GL11C.glFrontFace;
import static org.lwjgl.opengl.GL11C.glGetString;
import static org.lwjgl.opengl.GL11C.glViewport;
import static org.lwjgl.opengl.GL20C.GL_SHADING_LANGUAGE_VERSION;

public class Context {
  private static final Logger LOGGER = LogManager.getLogger(Context.class.getName());

  private static final float FOV = (float)(Math.PI / 4.0f);

  public final Camera camera;
  private final Matrix4f proj = new Matrix4f();
  private final Shader.UniformBuffer transforms;

  private final FloatBuffer transformsBuffer = BufferUtils.createFloatBuffer(4 * 4 * 2);

  private Runnable onDraw = () -> {};

  private int width;
  private int height;

  public Context(final Window window, final Camera camera) {
    window.events.onResize(this::onResize);
    window.events.onDraw(this::draw);
    this.camera = camera;

    window.makeContextCurrent();

    GL.createCapabilities();

    LOGGER.info("OpenGL version: {}", glGetString(GL_VERSION));
    LOGGER.info("GLSL version: {}", glGetString(GL_SHADING_LANGUAGE_VERSION));
    LOGGER.info("Device manufacturer: {}", glGetString(GL_VENDOR));

    if("true".equals(System.getenv("opengl_debug"))) {
      GLUtil.setupDebugMessageCallback(System.err);
    }

    glEnable(GL_DEPTH_TEST);
    glEnable(GL_CULL_FACE);
    glFrontFace(GL_CW);

    this.setClearColour(0.0f, 0.0f, 0.0f);

    this.transforms = new Shader.UniformBuffer((long)this.transformsBuffer.capacity() * Float.BYTES, Shader.UniformBuffer.TRANSFORM);
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setClearColour(final float red, final float green, final float blue) {
    glClearColor(red, green, blue, 1.0f);
  }

  public void onDraw(final Runnable onDraw) {
    this.onDraw = onDraw;
  }

  public void clear() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  }

  public void clearColour() {
    glClear(GL_COLOR_BUFFER_BIT);
  }

  public void setTransforms(final Camera camera, final Matrix4f projection) {
    camera.get(this.transformsBuffer);
    projection.get(16, this.transformsBuffer);
    this.transforms.set(this.transformsBuffer);
  }

  private void draw() {
    glViewport(0, 0, this.width, this.height);
    this.pre();
    this.onDraw.run();
  }

  private void pre() {
    // Update global transforms
    this.proj.setPerspectiveLH(FOV, (float)this.width / this.height, 0.1f, 500.0f);
    this.setTransforms(this.camera, this.proj);

    // Render scene
    this.clear();
  }

  private void onResize(final Window window, final int width, final int height) {
    if(width == 0 && height == 0) {
      return;
    }

    this.width = width;
    this.height = height;
  }
}
