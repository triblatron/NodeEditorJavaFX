package nodeeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("node.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("node.fxml"));
        VBox root = new VBox();
        Parent button1 = fxmlLoader.load();
        button1.setId("button1");
        Parent button2 = fxmlLoader2.load();
        button2.setId("button2");
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.layout();
        Scene scene = new Scene(root, 320, 240);
//        NodeEditorController controller = fxmlLoader.getController();
//        controller.init();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}