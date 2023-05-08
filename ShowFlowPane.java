/*
*Joel Avery 
*CSD-405
*4/21/23
*Module 7 Assignment
*/

/*
*This program demonstrates javaFx using a flow pane and when the screen changes
the items can flow with the expansion or contraction. This produces a form for 
name, State they live in, and phone number. 
*/

//Imports for JavaFx
import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.scene.Scene; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.FlowPane; 
import javafx.stage.Stage; 

public class ShowFlowPane extends Application {
    @Override //Overrides the start method in the Application Class
    public void start(Stage primaryStage){
        //Create a pane and set all of its properties
        FlowPane pane = new FlowPane(); 
        pane.setPadding(new Insets(10,10,10,10)); 
        pane.setHgap(5);
        pane.setVgap(5); 
        
        //Place nodes in the pane
        pane.getChildren().addAll(new Label("First Name:"),
            new TextField(), new Label("State:")); 
        TextField number = new TextField(); 
        number.setPrefColumnCount(1); 
        pane.getChildren().addAll(number, new Label("Phone Number:"),
                new TextField()); 
        
        //Create a scene and put it in the stage
        Scene scene = new Scene(pane, 180,250); 
        primaryStage.setTitle("Show the Flow Pane"); //set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); //Show the stage
    }
public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
}
    
}
