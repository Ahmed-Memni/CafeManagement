package com.JavaFx.Controllerfiles;


import com.cafe.models.ALL;
import com.cafe.models.Administrator;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginController {
    @FXML
    private Button GOCREATE;

    @FXML
    private Button LOGIN;

    @FXML
    private TextField Login_Password;

    @FXML
    private TextField Login_Username;

    @FXML
    private AnchorPane Si_Login;

    @FXML
    private AnchorPane always;
    private ALL all;


    public void setAll(ALL all) {
        this.all = all;
    }
    @FXML
    void Gocreate(ActionEvent event) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Create.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();

            // Get the controller and pass the ALL instance
            CreateController createController = loader.getController();
            createController.setAll(this.all);

            // Set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void login(ActionEvent event) {
String username = Login_Username.getText();
String password = Login_Password.getText();
Administrator adm = new Administrator(username,password);
        boolean fc ;
        fc = all.getAdm().contains(adm);
        if (fc) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Mainpage1.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();

            // Get the controller and pass the ALL instance
            MainpageController loginController = loader.getController();
            loginController.setAll(this.all);

            // Set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }}
        else { System.out.println("Wrong Username or Password");}
    }



}

