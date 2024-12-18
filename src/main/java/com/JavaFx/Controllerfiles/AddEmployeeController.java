package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import com.cafe.models.Server;
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

public class AddEmployeeController {

    @FXML
    private TextField Create_Adresse;

    @FXML
    private Button Create_Create;

    @FXML
    private TextField Create_Date;

    @FXML
    private TextField Create_Name;

    @FXML
    private TextField Create_Prenom;

    @FXML
    private TextField Create_Salaire;

    @FXML
    private TextField Create_Table;

    @FXML
    private TextField Create_Telephon;

    @FXML
    private Button GOEMPLOYEE;

    @FXML
    private AnchorPane Si_Create;
    private ALL all;


    public void setAll(ALL all) {
        this.all = all;
    }

    @FXML
    void createServer(ActionEvent event) {

        // Retrieve values from TextFields
        String adresse = Create_Adresse.getText();
        String date = Create_Date.getText();
        String nom = Create_Name.getText();
        String prenom = Create_Prenom.getText();
        String salaireText = Create_Salaire.getText();
        String table = Create_Table.getText();
        String tlfText = Create_Telephon.getText(); // Tlf is expected to be an integer as a string

        // Convert Salaire to double
        double salaire;
        try {
            salaire = Double.parseDouble(salaireText);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for Salaire: " + salaireText);
            salaire = 0.0; // Default value or handle error
        }

        // Convert Tlf to int
        int tlf;
        try {
            tlf = Integer.parseInt(tlfText);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for Tlf: " + tlfText);
            tlf = 0; // Default value or handle error
        }
        Integer number;
        try {
            number = Integer.parseInt(table);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for Table: " + table);
            number = 0; // Default value or handle error
        }
        Server server = new Server(0,nom,prenom,tlf,adresse,salaire,date,number);
        all.getServers().add(server);
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        try {
            // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();

            // Pass ALL to the next controller
            EmployeeController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
