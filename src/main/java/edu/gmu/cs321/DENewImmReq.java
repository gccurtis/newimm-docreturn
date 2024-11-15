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
        stage.setTitle("Document Request Form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Document Request Form");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 1, 1);

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

        Label requestedFormLabel = new Label("Requested Form:");
        grid.add(requestedFormLabel, 0, 9);

        TextField requestedFormTextField = new TextField();
        grid.add(requestedFormTextField, 1, 9);

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BASELINE_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 12);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        String invalidInput = "Invalid Input";

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
                String firstName = firstNameTextField.getText();
                String middleName = middleNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String dateOfBirth = dateOfBirthTextField.getText();
                String idString = iDTextField.getText();
                String email = emailTextField.getText();
                String race = raceTextField.getText();
                String gender = genderTextField.getText();
                String requestedForm = requestedFormTextField.getText();

                try {
                    String[] dateInfo = dateOfBirth.split("/");
                    if (dateInfo.length == 3) {
                        int month = Integer.parseInt(dateInfo[0]);
                        int day = Integer.parseInt(dateInfo[1]);
                        int year = Integer.parseInt(dateInfo[2]);
                        int id = Integer.parseInt(idString);
                        if (validateWord(firstName) && validateWord(middleName) && validateWord(lastName)
                                && validateID(id) && validateWord(email) && validateWord(race)
                                && validateWord(gender) && validateWord(requestedForm)) {
                            ImmReqForm newImmReqForm = new ImmReqForm(firstName, middleName, lastName,
                                    LocalDate.of(year, month, day), id, email, race, gender, requestedForm);
                            newImmReqForm.saveImmReqForm();
                            newImmReqForm.addWFItem();
                            Workflow thing = new Workflow();
                            WorkflowItem test = new WorkflowItem(newImmReqForm);
                            thing.addWorkflowItemToDB(test);
                            actiontarget.setText("New Request Form Submitted");
                        } else {
                            actiontarget.setText(invalidInput);
                        }
                    } else {
                        actiontarget.setText(invalidInput);
                    }
                } catch (Exception x) {
                    actiontarget.setText(invalidInput);
                }
            }
        });

        Scene scene = new Scene(grid, 370, 435);
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
     * @param yearOfBirth yearOfBirth is the date of birth being validated
     * @return returns true if yearOfBirth is within the range of 1920-2024, false
     *         otherwise
     */
    public static boolean validateBirthYear(int yearOfBirth) {
        if ((yearOfBirth < 1900) || (yearOfBirth > 2024))
            return false;
        return true;
    }

    /**
     * @param iD iD is the ID being validated
     * @return returns true if ID exists and is greater than 0, false otherwise
     */
    public static boolean validateID(int iD) {
        if (iD < 0)
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
