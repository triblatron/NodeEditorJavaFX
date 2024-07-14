package nodeeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TitledPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/nodeeditor/titledpane.fxml"));
            GridPane root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)    {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}