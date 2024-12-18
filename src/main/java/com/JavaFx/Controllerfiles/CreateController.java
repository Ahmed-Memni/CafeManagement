package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import com.cafe.models.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CreateController implements Initializable {

    @FXML
    private Button CREATE;

    @FXML
    private TextField Create_Answeer;

    @FXML
    private TextField Create_Cin;

    @FXML
    private TextField Create_Password;

    @FXML
    private ComboBox<String> Create_Question;

    @FXML
    private TextField Create_Username;

    @FXML
    private Button GOLOGIN;

    @FXML
    private AnchorPane Si_Create;



    /**
     * Handle user creation logic.
     * This will just log user creation details for testing.
     */
    @FXML
    void create(ActionEvent event) {
        String username = Create_Username.getText();
        String password = Create_Password.getText();
        String cin = Create_Cin.getText();
        String answer = Create_Answeer.getText();
        int num = Create_Question.getSelectionModel().getSelectedIndex();

        // Log user creation data
        System.out.println("User Created with:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("CIN: " + cin);
        System.out.println("Answer: " + answer);

        // Clear fields after submission (optional)
        Administrator adm= new Administrator(username,password,cin,num,answer);
        all.addAdministrator(adm);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate the ComboBox with values
        List<String> questionOptions = Arrays.asList(
                "What is your pet name ?",
                "What is your favorite soccerteam?",
                "Where do you live?",
                "What is your favorite color?"
        );

        Create_Question.getItems().addAll(questionOptions);

        // Optionally select a default value
        Create_Question.getSelectionModel().selectFirst();
    }
    /**
     * Go to Login Scene on button click
     */
    private ALL all;

    public void setAll(ALL all) {
        this.all = all;
    }
    @FXML
    void gologin(ActionEvent event) {     
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Login.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();

            // Get the controller and pass the ALL instance
            LoginController loginController = loader.getController();
            loginController.setAll(this.all);

            // Set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
