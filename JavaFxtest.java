import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxtest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TitledPane titledPane = new TitledPane();
        titledPane.setText("My TitledPane");
        titledPane.setContent(new Label("Hello, world!"));

        VBox root = new VBox(titledPane);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("TitledPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
