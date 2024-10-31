package edu.gmu.cs321;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;
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

public class DENewImmReq {

    private Stage stage;

    public DENewImmReq() {
        stage = new Stage();
        stage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
                actiontarget.setText(userTextField.getText());
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param word word is the word being validated
     * @return returns true if word isn't null or an empty string, false
     *         otherwise
     */
    public static boolean validateWord(String word) {
        if ((word == null) || (word.length() < 1))
            return false;
        return true;
    }

    /**
     * @param dateOfBirth dayOfBirth is the date of birth being validated
     * @return returns true if dayOfBirth is within the range of 1-31, false
     *         otherwise
     */
    public static boolean validateBirthDay(int dayOfBirth) {
        if ((dayOfBirth < 1) || (dayOfBirth > 31))
            return false;
        return true;
    }

    /**
     * @param monthOfBirth monthOfBirth is the date of birth being validated
     * @return returns true if monthOfBirth is within the range of 1-12, false
     *         otherwise
     */
    public static boolean validateBirthMonth(int monthOfBirth) {
        if ((monthOfBirth < 1) || (monthOfBirth > 12))
            return false;
        return true;
    }

    /**
     * @param yearOfBirth yearOfBirth is the date of birth being validated
     * @return returns true if yearOfBirth is within the range of 1920-2024, false
     *         otherwise
     */
    public static boolean validateBirthYear(int yearOfBirth) {
        if ((yearOfBirth < 1920) || (yearOfBirth > 2024))
            return false;
        return true;
    }

    /**
     * @param ID ID is the ID being validated
     * @return returns true if ID exists and is greater than 0, false otherwise
     */
    public static boolean validateID(int ID) {
        if (ID < 0)
            return false;
        return true;
    }

    /**
     * @param email email is the email being validated
     * @return returns true if email isn't null and contains the "@" and "."
     *         characters, false otherwise
     */
    public static boolean validateEmail(String email) {
        if ((email == null) || (!email.contains("@")) || (!email.contains(".")))
            return false;
        return true;
    }
}
