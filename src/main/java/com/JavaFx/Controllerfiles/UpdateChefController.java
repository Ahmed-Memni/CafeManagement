package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateChefController implements table, com.Interfaces.ComboBox {
    private ALL all;


    public void setAll(ALL all) {
        this.all = all;
        populateComboBox();
        populateComboBox1();
        populatetable();
    }
    @FXML
    private TextField Adresse;

    @FXML
    private ComboBox<String> Chosr;

    @FXML
    private Button Create_Create;

    @FXML
    private Button Create_Create1;

    @FXML
    private TextField DateEmbauche;

    @FXML
    private TextField NOM;

    @FXML
    private TextField Namespecialité;

    @FXML
    private TextField Prenom;

    @FXML
    private TextField Price;

    @FXML
    private TextField Salaire;

    @FXML
    private AnchorPane Si_Create;

    @FXML
    private AnchorPane Si_Login;

    @FXML
    private TableView<OrderItem> Specialité;

    @FXML
    private TextField Tlf;

    @FXML
    private AnchorPane always;

    @FXML
    private ComboBox<String> choixSpecialité;

    @FXML
    private TableColumn<OrderItem, String> name;

    @FXML
    private TableColumn<OrderItem, Double> price;

    @FXML
    void combobox(ActionEvent event) {

    }

    @FXML
    void combobox1(ActionEvent event) {

    }
    @Override
    public void populateComboBox() {
        if (Chosr == null) {
            System.err.println("ComboBox is null, check your FXML.");
            return;
        }

        Chosr.getItems().clear();
        if (all != null && all.getChefs() != null) {
            for (Chef chef : all.getChefs()) {
                System.out.println("Loading server into combo box: " + chef.getNom());
                Chosr.getItems().add(chef.getNom());
            }
        } else {
            System.err.println("No chef or all instance is null.");
        }
    }
    @Override
    public void populatetable() {
        if (Specialité == null) {
            System.err.println("TABLEVIEW is null. Check if the FXML is loaded properly.");
            return;
        }

        try {
            // Bind columns to fields
            name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            price.setCellValueFactory(cellData ->
                    new ReadOnlyObjectWrapper<>(cellData.getValue().getPrice())
            );


            // Populate the TableView
            ObservableList<OrderItem> itemsList = FXCollections.observableArrayList(all.getItems());
            Specialité.setItems(itemsList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the table view.");
        }
    }

    private void populateComboBox1() {
        if (choixSpecialité == null) {
            System.err.println("ComboBox is null, check your FXML.");
            return;
        }

        choixSpecialité.getItems().clear();
        if (all != null && all.getServers() != null) {
            for (OrderItem order : all.getItems()) {
                System.out.println("Loading server into combo box: " + order.getName());
                choixSpecialité.getItems().add(order.getName());
            }
        } else {
            System.err.println("No Items or all instance is null.");
        }
    }
    @FXML
    void goChef(ActionEvent event) throws IOException {
        // Load Scene2 using absolute path
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


    @FXML
    void tableview(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
        int num = Chosr.getSelectionModel().getSelectedIndex();
        int id = 1; // Set id manually or retrieve dynamically
        String nom = NOM.getText();
        String prenom = Prenom.getText();
        int telephone = Integer.parseInt(Tlf.getText());
        String adresse = Adresse.getText();
        double salaire = Double.parseDouble(Salaire.getText());

        String dateEmbaucheStr = DateEmbauche.getText();
        OrderItem orderr = new OrderItem();
        if (choixSpecialité.getSelectionModel().getSelectedItem() == null) {
            System.out.println("No selection made in ComboBox. keep the old orderitem");
            orderr = all.getChefs().get(num).retirerSpecialite();
        } else {
            String nomm = Namespecialité.getText();
            double price = Double.parseDouble(Price.getText());
            String selectedValue = choixSpecialité.getSelectionModel().getSelectedItem();
            System.out.println("User selected: " + selectedValue);
            orderr = new OrderItem(nomm,1,price);
        }
        Chef chef = new Chef(1,nom,prenom,telephone,adresse,salaire,dateEmbaucheStr,orderr);
     all.getChefs().remove(num);
        all.getChefs().add(chef);

    }

}
