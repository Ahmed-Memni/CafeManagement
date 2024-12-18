package com.JavaFx;

import com.JavaFx.Controllerfiles.CreateController;
import com.JavaFx.Controllerfiles.LoginController;
import com.cafe.models.ALL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URI;

public class CafeManagement extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            ALL all = new ALL();
            // Load the FXML file
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Create.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlFile.toURI().toURL());

            // Get the root node and controller
            Parent root = loader.load();
            CreateController createController = loader.getController();

            // Pass the ALL instance to the controller
            createController.setAll(all);

            primaryStage.setTitle("Cafe Management");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("The customer you provided was added successfully.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}