package edu.gmu.cs321;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * run using 'mvn clean javafx:run'
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        DENewImmReq test = new DENewImmReq();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
