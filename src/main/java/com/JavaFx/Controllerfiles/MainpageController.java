package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainpageController {

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBOARD;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GOSERVER;

    @FXML
    private Button SI_CLOSE;

    @FXML
    private Button SI_LOG_OUT;

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void gochef(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Chef.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            ChefController controller = loader.getController();
            controller.setAll(all);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private ALL all;
    public void setAll(ALL all) {
        this.all = all;
    }

    @FXML
    void gocustomers(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Customer.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            CustomerController controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void godashboard(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\DASHBORD.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            DASHBOARDController controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goinventory(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\INVENTORY.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            INVENTORYCONTROLLER controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gologout(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Create.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            CreateController controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void gomenu(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\MENU.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            MenuController controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    void goserver(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            EmployeeController controller = loader.getController();
            controller.setAll(all);
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
