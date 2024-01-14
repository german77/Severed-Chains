package legend.game.debugger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScriptDebugger extends Application {
  private ScriptDebuggerController controller;

  private int preselectScript;

  public ScriptDebugger preselectScript(final int preselectScript) {
    this.preselectScript = preselectScript;
    return this;
  }

  @Override
  public void start(final Stage stage) throws Exception {
    final FXMLLoader loader = new FXMLLoader(this.getClass().getResource("script_debugger.fxml"));
    final Parent root = loader.load();
    final Scene scene = new Scene(root);
    scene.getStylesheets().add(this.getClass().getResource("script_debugger.css").toExternalForm());

    this.controller = loader.getController();
    this.controller.selectScript(this.preselectScript);

    stage.setOnCloseRequest(event -> {
      this.controller.uninitialize();
      this.controller = null;
    });

    stage.setTitle("Script Debugger");
    stage.setScene(scene);
    stage.setX(Debugger.getStage().getX() + ((Debugger.getStage().getWidth() - root.prefWidth(-1)) / 2));
    stage.setY(Debugger.getStage().getY() + ((Debugger.getStage().getHeight() - root.prefHeight(-1)) / 2));
    stage.show();
  }
}
