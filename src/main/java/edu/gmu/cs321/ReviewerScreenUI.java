package edu.gmu.cs321;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReviewerScreenUI {

    private Stage stage;

    public ReviewerScreenUI() {
        // Initialize the stage (window)
        stage = new Stage();
        // Set the title of the stage
        stage.setTitle("Immigrant Form Review");

        // Create a GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Title text
        Text scenetitle = new Text("Immigrant Form Review");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1); // Adds the title spanning 2 columns

        Label firstNameLabel = new Label("First Name:");
        grid.add(firstNameLabel, 0, 1);

        TextField firstNameTextField = new TextField();
        grid.add(firstNameTextField, 1, 1);

        Label middleNameLabel = new Label("Middle Name:");
        grid.add(middleNameLabel, 0, 2);

        TextField middleNameTextField = new TextField();
        grid.add(middleNameTextField, 1, 2);

        Label lastNameLabel = new Label("Last Name:");
        grid.add(lastNameLabel, 0, 3);

        TextField lastNameTextField = new TextField();
        grid.add(lastNameTextField, 1, 3);

        Label dateOfBirthLabel = new Label("Date of Birth (MM/DD/YYYY):");
        grid.add(dateOfBirthLabel, 0, 4);

        TextField dateOfBirthTextField = new TextField();
        grid.add(dateOfBirthTextField, 1, 4);

        Label iDLabel = new Label("ID:");
        grid.add(iDLabel, 0, 5);

        TextField iDTextField = new TextField();
        grid.add(iDTextField, 1, 5);

        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 6);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 6);

        Label raceLabel = new Label("Race:");
        grid.add(raceLabel, 0, 7);

        TextField raceTextField = new TextField();
        grid.add(raceTextField, 1, 7);

        Label genderLabel = new Label("Gender:");
        grid.add(genderLabel, 0, 8);

        TextField genderTextField = new TextField();
        grid.add(genderTextField, 1, 8);

        // Fields need more implementation to pull from data base the exixting data
        
        

        // Button to save changes
        Button saveButton = new Button("Save Changes");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(saveButton);
        grid.add(hbBtn, 1, 9);

        // Text to display messages or feedback
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 10, 2, 1); // Adjust row as necessary

        // Event handler for the "Save Changes" button
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Data updated successfully");
            }
        });

        // Create the scene and show the stage
        Scene scene = new Scene(grid, 400, 400); // Adjust size if needed
        stage.setScene(scene);
        stage.show();
    }
}
