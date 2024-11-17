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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApprovalScreenUI {

    private Stage stage;

    public ApprovalScreenUI(Workflow wf) {
        // Create a function to pass next ImmReqForm
	// TODO: Handle an empty database
	
	WorkflowItem wfi = wf.getNextWorkflowItem();
	if (wfi == null) {
		System.out.println("No DATA 1");
		return;
	}
	while (wfi.getReviewFlag()) {
		wfi = wf.getNextWorkflowItem();
		if (wfi == null) {
			System.out.println("No DATA");
			return;
		}
	}

	ImmReqForm immData = wfi.getForm();
	
        stage = new Stage();
        stage.setTitle("Document Request Approval");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Document Request Approval");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label firstName = new Label("First Name:");
        grid.add(firstName, 0, 1);
        Label firstNameVal = new Label(immData.getFirstName());
        grid.add(firstNameVal, 1, 1);

        Label middleName = new Label("Middle Name:");
        grid.add(middleName, 0, 2);
        Label middleNameVal = new Label(immData.getMiddleName());
        grid.add(middleNameVal, 1, 2);

        Label lastName = new Label("Last Name:");
        grid.add(lastName, 0, 3);
        Label lastNameVal = new Label(immData.getLastName());
        grid.add(lastNameVal, 1, 3);

        Label dateOfBirthLabel = new Label("Date of Birth (MM/DD/YYYY):");
        grid.add(dateOfBirthLabel, 0, 4);
        Label dateOfBirthVal = new Label(immData.getDateOfBirth().toString());
        //Label dateOfBirthVal = new Label("Work-In-Progress");
	grid.add(dateOfBirthVal, 1, 4);

        Label idLabel = new Label("ID:");
        grid.add(idLabel, 0, 5);
        Label idVal = new Label(new Integer(immData.getID()).toString());
        grid.add(idVal, 1, 5);

        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 6);
        Label emailVal = new Label(immData.getEmail());
        grid.add(emailVal, 1, 6);

        Label raceLabel = new Label("Race:");
        grid.add(raceLabel, 0, 7);
        Label raceVal = new Label(immData.getRace());
        grid.add(raceVal, 1, 7);

        Label genderLabel = new Label("Gender:");
        grid.add(genderLabel, 0, 8);
        Label genderVal = new Label(immData.getGender());
        grid.add(genderVal, 1, 8);

        Label requestedFormLabel = new Label("Requested Form:");
        grid.add(requestedFormLabel, 0, 9);
        Label requestedFormVal = new Label(immData.getRequestedDoc());
        grid.add(requestedFormVal, 1, 9);

        Button btn = new Button("Approve");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BASELINE_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 10);

        Button btn2 = new Button("Reject");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BASELINE_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 1, 10);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 12);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Approval button pressed");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Reject button pressed");
            }
        });

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
