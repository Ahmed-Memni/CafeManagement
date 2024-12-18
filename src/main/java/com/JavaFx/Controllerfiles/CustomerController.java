package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.ALL;
import com.cafe.models.Customer;
import com.cafe.models.OrderItem;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CustomerController implements table {

    @FXML
    private Button ADDCUSTOMER;

    @FXML
    private Button DELETE;

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCLOSE;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBORD;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOLOGOUT;

    @FXML
    private Button GOMENU;
    @FXML
    private Button ADDCUSTOMER1;

    @FXML
    private Button GOSERVER;

    @FXML
    private TextField NAME;

    @FXML
    private TextField PRENOM;

    @FXML
    private TextField SEARCH;

    @FXML
    private TableView<Customer> TABLEVIEW;

    @FXML
    private TextField TLF;

    @FXML
    private TableColumn<Customer, String> nameColumn;


    @FXML
    private TableColumn<Customer, Integer> telephoneColumn;

    @FXML
    private TableColumn<Customer, Double> moneySpentColumn;

    @FXML
    private TableColumn<Customer, String> mostItemBoughtColumn;

    @FXML
    private TableColumn<Customer, Integer> loyaltyPointsColumn;

    private ALL all;

    public void setAll(ALL all) {
        this.all = all;
        if (all.getCusts().isEmpty()) System.out.println("nothing to show");
        else {populatetable();}
    }

    @FXML
    void gochef(ActionEvent event) {
        try {
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
    void resettable(ActionEvent event) {
        populatetable();

    }

    @FXML
    void goclose(ActionEvent event) {
        Platform.exit();
    }


    @Override
    public void populatetable()
    {
        if (TABLEVIEW == null) {
            System.err.println("TABLEVIEW is null. Check if the FXML is loaded properly.");
            return;
        }

        try {
            // Bind columns to fields
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            loyaltyPointsColumn.setCellValueFactory(new PropertyValueFactory<>("loyaltyPoints"));
            telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            moneySpentColumn.setCellValueFactory(new PropertyValueFactory<>("moneySpent"));

            mostItemBoughtColumn.setCellValueFactory(cellData -> {
                OrderItem mostItem = cellData.getValue().getMostItemBought();
                String itemName = (mostItem != null) ? mostItem.getName() : "No Item";
                return new javafx.beans.property.SimpleStringProperty(itemName);
            });

            ObservableList<Customer> customerList = FXCollections.observableArrayList(all.getCusts());
            TABLEVIEW.setItems(customerList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the table view.");
        }


    }
    @FXML
    void godashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\DASHBORD.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            DASHBOARDController controller = loader.getController();
            controller.setAll(all);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gologout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Create.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            CreateController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goserver(ActionEvent event) {
        try {
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
    void gocustomers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Customer.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            CustomerController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TABLEVIEW(SortEvent<TableView<Customer>> tableViewSortEvent) {
    }

    public void search(ActionEvent actionEvent) {
        List<Customer> cu =  all.getCusts().stream()
                .filter(customer -> customer.getNom().equalsIgnoreCase(SEARCH.getText()))
                .collect(Collectors.toList());
        TABLEVIEW.setItems(FXCollections.observableArrayList());
        ObservableList<Customer> customerList = FXCollections.observableArrayList(cu);
        TABLEVIEW.setItems(customerList);

    }

    public void goinventory(ActionEvent actionEvent) {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\INVENTORY.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            INVENTORYCONTROLLER controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletecustomer(ActionEvent actionEvent) {
        String nameText = NAME.getText();
        String prenomText = PRENOM.getText();
        String tlfText = TLF.getText();
        // Convertir TLF en entier
        int tlf;
        try {
            tlf = Integer.parseInt(tlfText);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for Tlf: " + tlfText);
            tlf = 0; // Default value or handle error
        }
        Customer customer = new Customer(1,nameText,tlf,prenomText);
        all.getCusts().remove(customer);
        populatetable();
    }

        public void addcustomer(ActionEvent actionEvent) {
        String nameText = NAME.getText();
        String prenomText = PRENOM.getText();
        String tlfText = TLF.getText();
        // Convertir TLF en entier
        int tlf;
        try {
            tlf = Integer.parseInt(tlfText);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for Tlf: " + tlfText);
            tlf = 0; // Default value or handle error
        }

        Customer customer = new Customer(1,nameText,tlf,prenomText);
        all.addCustomer(customer);
        populatetable();
    }

    public void gomenu(ActionEvent actionEvent) {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\MENU.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            MenuController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
