/*
Joel Avery 
CSD-405
Module 10 Assignment
05/04/23
*/

/**

This program displays a set of 4 playing cards on a VBox layout Container. The card images are loaded
from files and ImageView instances are created for each card. The program also includes a refresh button
that randomly selects 4 new cards to display when clicked.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class RefreshCards extends Application {
    // ArrayList to store card numbers
private ArrayList<Integer> cardNumbers = new ArrayList<>();

@Override
public void start(Stage primaryStage) {

    // Create a new VBox layout Container
    VBox cardBox = new VBox();

    // Load the card images from file and create ImageView instances for each card
    for (int i = 1; i <= 54; i++) {
        cardNumbers.add(i);
    }

    // Shuffle the card numbers
    Collections.shuffle(cardNumbers);

    // Create a new HBox layout Container to display 4 cards at a time
    HBox row1 = new HBox();

    // Add the ImageView instances for the first 4 cards
    for (int i = 0; i < 4; i++) {
        try {
            Image cardImage = new Image("file:./src/module10/" + cardNumbers.get(i) + ".png");
            ImageView cardView = new ImageView(cardImage);
            row1.getChildren().add(cardView);
        } catch (IllegalArgumentException e) {
            // If the image cannot be loaded, add a placeholder image instead
            Image placeholderImage = new Image("file:./src/module10/placeholder.png");
            ImageView placeholderView = new ImageView(placeholderImage);
            row1.getChildren().add(placeholderView);
        }
    }

    // Add the first row to the cardBox
    cardBox.getChildren().add(row1);

    // Create a refresh button to display a new set of 4 cards
    javafx.scene.control.Button refreshButton = new javafx.scene.control.Button("Refresh");
    refreshButton.setOnAction(actionEvent -> {
        // Create a new HBox layout Container to display 4 cards at a time
        HBox newRow = new HBox();

        // Select 4 random card numbers
        Collections.shuffle(cardNumbers);
        ArrayList<Integer> selectedCardNumbers = new ArrayList<>(cardNumbers.subList(0, 4));

        // Add the ImageView instances for the selected cards
        for (int i = 0; i < 4; i++) {
            try {
                Image cardImage = new Image("file:./src/module10/" + selectedCardNumbers.get(i) + ".png");
                ImageView cardView = new ImageView(cardImage);
                newRow.getChildren().add(cardView);
            } catch (IllegalArgumentException e) {
                // If the image cannot be loaded, add a placeholder image instead
                Image placeholderImage = new Image("file:./src/module10/placeholder.png");
                ImageView placeholderView = new ImageView(placeholderImage);
                newRow.getChildren().add(placeholderView);
            }
        }

        // Replace the old row with the new row
        cardBox.getChildren().set(0, newRow);
    });

    // Add the refresh button to the cardBox
    cardBox.getChildren().add(refreshButton);

    // Create a scene with the cardBox as the root node and show it
    Scene scene = new Scene(cardBox);
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}

}