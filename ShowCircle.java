

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.*; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.scene.text.*; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 

public class ShowCircle extends Application {
    @Override
       public void start(Stage primaryStage){
           
           StackPane pane = new StackPane();            
           Circle circle = new Circle(); 
           circle.centerXProperty().bind(pane.widthProperty().divide(2));
           circle.centerYProperty().bind(pane.heightProperty().divide(2));  
           circle.setRadius(50);
           circle.setStroke(Color.BLACK);
           circle.setFill(Color.YELLOW);
           
           pane.getChildren().add(circle); 
           
           Label label = new Label("JavaFx"); 
           label.setFont(Font.font("Times New Roman", 
                   FontWeight.BOLD, FontPosture.ITALIC, 20)); 
           pane.getChildren().add(label); 
           
           
           
           Scene scene = new Scene(pane, 200, 200); 
           primaryStage.setTitle("Show Circle");
           primaryStage.setScene(scene); 
           primaryStage.show(); 
           
       }
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args); 
    }
    
}
