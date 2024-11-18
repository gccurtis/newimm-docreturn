package edu.gmu.cs321;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import static javafx.geometry.HPos.RIGHT;
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

        public ImmReqForm nextImmReqFormFromWorkflow(Workflow wf, Boolean desiredReviewFlag) {
                WorkflowItem wfi = wf.getNextWorkflowItem();
                if (wfi == null) {
                        return null;
                }
                while (wfi.getReviewFlag() != desiredReviewFlag) {
                        wfi = wf.getNextWorkflowItem();
                        if (wfi == null) {
                                return null;
                        }
                }
                return wfi.getForm();
        }

        public ReviewerScreenUI(Workflow wf) {

                ImmReqForm immData = nextImmReqFormFromWorkflow(wf, true);
                if (immData == null) {
                        System.out.println("No DATA");
                        System.exit(0);
                        return;
                }

                stage = new Stage();
                stage.setTitle("Immigrant Form Review");
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));

                Text scenetitle = new Text("Immigrant Form Review");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(scenetitle, 0, 0, 2, 1); // Adds the title spanning 2 columns

                Label firstNameLabel = new Label("First Name:");
                grid.add(firstNameLabel, 0, 1);
                Label firstNameVal = new Label(immData.getFirstName());
                grid.add(firstNameVal, 1, 1);
                TextField firstNameTextField = new TextField();
                grid.add(firstNameTextField, 2, 1);

                Label middleNameLabel = new Label("Middle Name:");
                grid.add(middleNameLabel, 0, 2);
                Label middleNameVal = new Label(immData.getMiddleName());
                grid.add(middleNameVal, 1, 2);
                TextField middleNameTextField = new TextField();
                grid.add(middleNameTextField, 2, 2);

                Label lastNameLabel = new Label("Last Name:");
                grid.add(lastNameLabel, 0, 3);
                Label lastNameVal = new Label(immData.getLastName());
                grid.add(lastNameVal, 1, 3);
                TextField lastNameTextField = new TextField();
                grid.add(lastNameTextField, 2, 3);

                Label dateOfBirthLabel = new Label("Date of Birth (MM/DD/YYYY):");
                grid.add(dateOfBirthLabel, 0, 4);
                Label dateOfBirthVal = new Label(immData.getDateOfBirth().getMonthValue() + "-"
                                + immData.getDateOfBirth().getDayOfMonth() + "-"
                                + immData.getDateOfBirth().getYear());
                grid.add(dateOfBirthVal, 1, 4);
                TextField dateOfBirthTextField = new TextField();
                grid.add(dateOfBirthTextField, 2, 4);

                Label iDLabel = new Label("ID:");
                grid.add(iDLabel, 0, 5);
                Label idVal = new Label(new Integer(immData.getID()).toString());
                grid.add(idVal, 1, 5);
                TextField iDTextField = new TextField();
                grid.add(iDTextField, 2, 5);

                Label emailLabel = new Label("Email:");
                grid.add(emailLabel, 0, 6);
                Label emailVal = new Label(immData.getEmail());
                grid.add(emailVal, 1, 6);
                TextField emailTextField = new TextField();
                grid.add(emailTextField, 2, 6);

                Label raceLabel = new Label("Race:");
                grid.add(raceLabel, 0, 7);
                Label raceVal = new Label(immData.getRace());
                grid.add(raceVal, 1, 7);
                TextField raceTextField = new TextField();
                grid.add(raceTextField, 2, 7);

                Label genderLabel = new Label("Gender:");
                grid.add(genderLabel, 0, 8);
                Label genderVal = new Label(immData.getGender());
                grid.add(genderVal, 1, 8);
                TextField genderTextField = new TextField();
                grid.add(genderTextField, 2, 8);

                Label requestedFormLabel = new Label("Requested Form:");
                grid.add(requestedFormLabel, 0, 9);
                Label requestedFormVal = new Label(immData.getRequestedDoc());
                grid.add(requestedFormVal, 1, 9);
                TextField requestedFormTextField = new TextField();
                grid.add(requestedFormTextField, 2, 9);

                Button saveButton = new Button("Save Changes");
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                hbBtn.getChildren().add(saveButton);
                grid.add(hbBtn, 1, 10);

                final Text actiontarget = new Text();
                grid.add(actiontarget, 0, 12);
                grid.setColumnSpan(actiontarget, 2);
                grid.setHalignment(actiontarget, RIGHT);
                actiontarget.setId("actiontarget");

                saveButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                                actiontarget.setFill(Color.GREEN);
                                actiontarget.setText("Data updated successfully");
                                String firstName = firstNameTextField.getText();
                                if (firstName != "")
                                        immData.setFirstName(firstName);
                                String middleName = middleNameTextField.getText();
                                if (middleName != "")
                                        immData.setMiddleName(middleName);
                                String lastName = lastNameTextField.getText();
                                if (lastName != "")
                                        immData.setLastName(lastName);
                                String dateOfBirth = dateOfBirthTextField.getText();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                                if (dateOfBirth != "")
                                        immData.setDateOfBirth(LocalDate.parse(dateOfBirth, formatter));
                                String idString = iDTextField.getText();
                                if (idString != "")
                                        immData.setID(Integer.parseInt(idString));
                                String email = emailTextField.getText();
                                if (email != "")
                                        immData.setEmail(email);
                                String race = raceTextField.getText();
                                if (race != "")
                                        immData.setRace(race);
                                String gender = genderTextField.getText();
                                if (gender != "")
                                        immData.setGender(gender);
                                String requestedForm = requestedFormTextField.getText();
                                if (requestedForm != "")
                                        immData.setRequestedDoc(requestedForm);
                                wf.dropImmReqForm(immData.getID());
                                wf.addWorkflowItemToDB(new WorkflowItem(immData, false));

                                ImmReqForm immData2 = nextImmReqFormFromWorkflow(wf, true);
                                if (immData2 == null) {
                                        System.out.println("No DATA");
                                        System.exit(0);
                                        return;
                                }

                                firstNameVal.setText(immData2.getFirstName());
                                middleNameVal.setText(immData2.getMiddleName());
                                lastNameVal.setText(immData2.getLastName());
                                dateOfBirthVal.setText(immData2.getDateOfBirth().toString());
                                idVal.setText(new Integer(immData2.getID()).toString());
                                emailVal.setText(immData2.getEmail());
                                raceVal.setText(immData2.getRace());
                                genderVal.setText(immData2.getGender());
                                requestedFormVal.setText(immData2.getRequestedDoc());
                        }
                });

                Scene scene = new Scene(grid, 400, 400); // Adjust size if needed
                stage.setScene(scene);
                stage.show();
        }
}
