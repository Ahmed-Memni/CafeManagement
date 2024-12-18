package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import com.cafe.models.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import java.util.ResourceBundle;

public class UpdateEmployeeController implements Initializable, com.Interfaces.ComboBox {

    @FXML
    private TextField Adresse;

    @FXML
    private ComboBox<String> CHOIXSERVER;

    @FXML
    private TextField Date;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;
    private ALL all;

    @FXML
    private Button RetourServer;

    @FXML
    private TextField Salaire;

    @FXML
    private AnchorPane Si_Create;

    @FXML
    private TextField TABLE;

    @FXML
    private TextField Tlf;

    @FXML
    private Button UpdateServer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            System.out.println("Controller initialized");

           }
           @Override
    public void populateComboBox() {
        if (CHOIXSERVER == null) {
            System.err.println("ComboBox is null, check your FXML.");
            return;
        }

        CHOIXSERVER.getItems().clear();
        if (all != null && all.getServers() != null) {
            for (Server server : all.getServers()) {
                System.out.println("Loading server into combo box: " + server.getNom());
                CHOIXSERVER.getItems().add(server.getNom());
            }
        } else {
            System.err.println("No servers or all instance is null.");
        }
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        // Load Scene2 using absolute path
            try {  // Load Scene2 using absolute path
                FXMLLoader loader = new FXMLLoader();
                File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml");
                loader.setLocation(fxmlFile.toURI().toURL());

                Parent root = loader.load();
                EmployeeController controller = loader.getController();
                controller.setAll(all);

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @FXML
    void update(ActionEvent event) {
        int num = CHOIXSERVER.getSelectionModel().getSelectedIndex();
        // Retrieve values from TextFields
        String adresse = Adresse.getText();
        String date = Date.getText();
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        String salaireText = Salaire.getText();
        String table = TABLE.getText();
        String tlfText = Tlf.getText(); // Tlf is expected to be an integer as a string

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
        all.getServers().remove(num);
        all.getServers().add(server);
        //Server(Nom,Prenom,Tlf,Adresse,);  public Server(int id, String nom, String prenom, int telephone, String adresse, double salaire, String dateEmbaucheStr) {
        //        super(id, nom, prenom, telephone, adresse, salaire, dateEmbaucheStr);


    }


    public void setAll(ALL all) {
        this.all=all;
            populateComboBox();
        }

    public void combobox(ActionEvent actionEvent) {
    }
}
