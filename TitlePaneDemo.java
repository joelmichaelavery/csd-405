/*
*Joel Avery 
*CSD-405
Module 7 
04/20/23
*/

/*
*This Program uses JavaFX Titled Pane to create a titledPane that has a button 
*graphic, Shows the title, as well as adds a button graphic and a click me 
*button when the user expands the pane. 
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitlePaneDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        
        // Create a TitledPane with title and content
        TitledPane titledPane = new TitledPane("My TitledPane", new Button("Click me!"));
        
        // Set the collapsible property to true (default value)
        titledPane.setCollapsible(true);
        
        // Set the expandable state to true (default value)
        titledPane.setExpanded(true);
        
        // Set an animation for collapsing/expanding
        titledPane.setAnimated(true);
        
        // Set a graphic for the TitledPane
        titledPane.setGraphic(new Button("Button graphic"));
        
        // Set some custom styling for the TitledPane using CSS
        titledPane.setStyle("-fx-background-color: lightblue; -fx-font-size: 16px;");
        
        // Create a VBox to hold the TitledPane
        VBox vbox = new VBox(titledPane);
        
        // Create a Scene and add the VBox to it
        Scene scene = new Scene(vbox, 400, 400);
        
        // Set the stage's title and scene, then show the stage
        stage.setTitle("TitledPane Demo");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
