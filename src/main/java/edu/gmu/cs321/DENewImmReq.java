package edu.gmu.cs321;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DENewImmReq extends Application {

    /**
     * @param firstName    firstName will be the stored first name
     * @param middleName   middleName will be the stored middle name
     * @param lastName     lastName will be the stored last name
     * @param dateOfBirth  dateOfBirth will be the stored date of birth
     * @param ID           ID will be the stored ID
     * @param email        email will be the stored email
     * @param race         race will be the stored race
     * @param gender       gender will be the stored race
     * @param requestedDoc requestedDoc will be the stored requested document
     * @return returns a new ImmReqForm created using the passed parameters
     * 
     *         (User input needs to be collected from the UI)
     */
    public ImmReqForm newImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int ID,
            String email, String race, String gender, String requestedDoc) {
        return new ImmReqForm(firstName, middleName, lastName, dateOfBirth, ID, email, race, gender, requestedDoc);
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
     * @param dateOfBirth dateOfBirth is the date of birth being validated
     * @return returns true if dateOfBirth isn't null, false otherwise
     */
    public static boolean validateDOB(LocalDate dateOfBirth) {
        if (dateOfBirth == null)
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
