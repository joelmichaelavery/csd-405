import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambdaExpressionsDemo extends Application {

    // Example of a Lambda expression that takes an integer and returns its square
    public static void squareExample(int num) {
        int square = num * num;
        System.out.println("The square of " + num + " is " + square);
    }

    // Example of using Lambda expressions to filter a list of integers and return only the even numbers
    public static List<Integer> filterExample(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the input fields for the squareExample method
        Label numLabel = new Label("Enter a number:");
        TextField numField = new TextField();
        Button squareButton = new Button("Calculate square");
        Label squareLabel = new Label();

        // Set the action for the squareButton using a Lambda expression
        squareButton.setOnAction(e -> {
            int num = Integer.parseInt(numField.getText());
            squareExample(num);
            squareLabel.setText("The square of " + num + " is " + num * num);
        });

        // Create the input field for the filterExample method
        Label numbersLabel = new Label("Enter a list of comma-separated numbers:");
        TextField numbersField = new TextField();
        Button filterButton = new Button("Filter even numbers");
        Label evenNumbersLabel = new Label();

        // Set the action for the filterButton using a Lambda expression
        filterButton.setOnAction(e -> {
            List<Integer> numbers = Arrays.asList(numbersField.getText().split(",")).stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> evenNumbers = filterExample(numbers);
            evenNumbersLabel.setText("Even numbers: " + evenNumbers);
        });

        // Create the button for the buttonExample method
        Button button = new Button("Click me!");

        // Set the action for the button using a Lambda expression
        button.setOnAction(e -> System.out.println("Button clicked!"));

        // Create the layouts for the GUI
        GridPane inputPane = new GridPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10, 10, 10, 10));
        inputPane.add(numLabel, 0, 0);
        inputPane.add(numField, 1, 0);
        inputPane.add(squareButton, 2, 0);
        inputPane.add(squareLabel, 0, 1, 3, 1);

        GridPane filterPane = new GridPane();
        filterPane.setHgap(10);
        filterPane.setVgap(10);
        filterPane.setPadding(new Insets(10, 10, 10, 10));
        filterPane.add(numbersLabel, 0, 0);
        filterPane.add(numbersField, 1, 0);
        filterPane.add(filterButton, 2, 0);
        filterPane.add(evenNumbersLabel, 0, 1, 3, 1);

        HBox buttonPane = new HBox(10);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().add(button);

    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    root.getChildren().addAll(inputPane, filterPane, buttonPane);

    Scene scene = new Scene(root, 600, 400);

    primaryStage.setTitle("Lambda Expressions Demo");
    primaryStage.setScene(scene);
    primaryStage.show();

    }
    public static void main(String[] args){
        Application.launch(args);
    }
        }
