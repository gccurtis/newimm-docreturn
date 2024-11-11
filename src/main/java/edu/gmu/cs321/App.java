package edu.gmu.cs321;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * run using 'mvn clean javafx:run'
 */
public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		String screenType = System.getProperty("screen.type");
		ApprovalScreenUI testa;
		DENewImmReq testde;
		if (screenType.equals("E"))
			testde = new DENewImmReq();
		if (screenType.equals("A"))
			testa = new ApprovalScreenUI();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the corresponding number for the following:\n1. Data Entry\n2. Review\n3. Approval");
		int choice = scanner.nextInt();
		System.out.println("You entered: " + choice);

		if (choice == 1)
			System.setProperty("screen.type", "E");
		if (choice == 3)
			System.setProperty("screen.type", "A");
		launch(args);
	}
}
