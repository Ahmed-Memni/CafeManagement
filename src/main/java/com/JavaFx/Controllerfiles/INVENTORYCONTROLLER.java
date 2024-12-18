package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.*;
import javafx.application.Platform;
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

public class INVENTORYCONTROLLER implements Initializable, table, com.Interfaces.ComboBox {
    private ALL all;

    public void setAll(ALL all) {
        this.all = all;
        if (all.getStocks().isEmpty()) System.out.println("No stocks found");
            else {
            populatetable();
            populateComboBox();
        }

    }

    @FXML
    private Button CLOSE;

    @FXML
    private TableColumn<Stock, String> CompanyName;

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBOARD;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOLOGOUT;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GOServer;

    @FXML
    private TableColumn<Stock, Integer> NumeroTlf;

    @FXML
    private TableColumn<Stock, Integer> Orderid;

    @FXML
    private TableColumn<Stock, String> ProductName;

    @FXML
    private TextField Quantity;

    @FXML
    private TableColumn<Stock, Integer> QuantityName;

    @FXML
    private TableColumn<Stock, Integer> SSupplierid;

    @FXML
    private TableColumn<Stock, String> SupplierNom;

    @FXML
    private Button add;

    @FXML
    private Button clear;

    @FXML
    private ComboBox<String> comboboxx;

    @FXML
    private Button delete;

    @FXML
    private TextField gettext;

    @FXML
    private TextField id;

    @FXML
    private TextField idd;

    @FXML
    private TextField namee;

    @FXML
    private TextField nameee;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TableView<Stock> tableview;

    @FXML
    private TextField tlf;

    @FXML
    private Button update;

    @FXML
    void add(ActionEvent event) {
        String nomm = nom.getText();
        String prenomm = prenom.getText();
        int iddd = Integer.parseInt(id.getText());
        int i = Integer.parseInt(idd.getText());
        Integer tlff = Integer.parseInt(tlf.getText());
        String nameeee = namee.getText();
        String name = nameee.getText();
        int quantity = Integer.parseInt(Quantity.getText());

        Supplier supplier = new Supplier(iddd, nomm, prenomm, tlff, name);
        if (comboboxx.getSelectionModel().getSelectedItem() == null) {
         System.out.println("no selected supplier building new supplier ");
        }
        else {
            comboboxx.getSelectionModel().getSelectedIndex();
            supplier = all.getSuppliers().get(i);
        }
        Stock stock = new Stock(i,name,supplier,quantity);
        all.getStocks().add(stock);
        all.getSuppliers().add(supplier);
        populatetable();
        populateComboBox();
    }

    @Override
    public void populatetable() {
        try {
            // Bind columns to fields
            CompanyName.setCellValueFactory(cellData -> {
                Supplier supplier = cellData.getValue().getTypeSupplier();
                String name = (supplier != null) ? supplier.getCompanyName() : "No Company";
                return new javafx.beans.property.SimpleStringProperty(name);
            });

            NumeroTlf.setCellValueFactory(cellData -> {
                Supplier supplier = cellData.getValue().getTypeSupplier();
                Integer tlf = (supplier != null) ? supplier.getTelephone() : null;
                return new javafx.beans.property.SimpleObjectProperty<>(tlf);
            });

            SSupplierid.setCellValueFactory(cellData -> {
                Supplier supplier = cellData.getValue().getTypeSupplier();
                Integer id = (supplier != null) ? supplier.getTelephone() : null;
                return new javafx.beans.property.SimpleObjectProperty<>(id);
            });

            SupplierNom.setCellValueFactory(cellData -> {
                Supplier supplier = cellData.getValue().getTypeSupplier();
                String nom = (supplier != null) ? supplier.getNom() : "No Supplier";
                return new javafx.beans.property.SimpleStringProperty(nom);
            });

            // Bind other Stock-specific columns
            Orderid.setCellValueFactory(new PropertyValueFactory<>("Id"));
            ProductName.setCellValueFactory(new PropertyValueFactory<>("nom"));
            QuantityName.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            // Populate the table with Stock data
            ObservableList<Stock> stockList = FXCollections.observableArrayList(all.getStocks());
            tableview.setItems(stockList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the table view.");
        }
    }



    @FXML
    void clear(ActionEvent event) {
        all.getStocks().clear();
        all.getSuppliers().clear();
        populatetable();
        populateComboBox();

    }
    @Override
    public void populateComboBox() {
        if (comboboxx == null) {
            System.err.println("ComboBox is null, check your donné.");
            return;
        }
        comboboxx.getItems().clear();
        if (all != null && all.getSuppliers() != null) {
            for (Supplier supplier : all.getSuppliers()) {
                System.out.println("Loading supplier into combo box: " + supplier.getNom());
                comboboxx.getItems().add(supplier.getNom());
            }
        } else {
            System.err.println("No supplier or all instance is null.");
        }
    }
    @FXML
    void combobox(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {
        String nomm = nom.getText();
        String prenomm = prenom.getText();
        int iddd = Integer.parseInt(id.getText());
        int i = Integer.parseInt(idd.getText());
        Integer tlff = Integer.parseInt(tlf.getText());
        String nameeee = namee.getText();
        String name = nameee.getText();
        int quantity = Integer.parseInt(Quantity.getText());

        Supplier supplier = new Supplier(iddd,nomm,prenomm,tlff,name);
        Stock stock = new Stock(i,name,supplier,quantity);
        all.getStocks().remove(stock);
        all.getSuppliers().remove(supplier);
        populatetable();
        populateComboBox();


    }

    @FXML
    void gochef(ActionEvent event) {try {  // Load Scene2 using absolute path
        FXMLLoader loader = new FXMLLoader();
        File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Chef.fxml");
        loader.setLocation(fxmlFile.toURI().toURL());

        Parent root = loader.load();
        ChefController controller = loader.getController();
        controller.setAll(all);
        // Get current stage and set new scene
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    @FXML
    void goclos(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void gocustomers(ActionEvent event) {try {  // Load Scene2 using absolute path
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
    void godashboard(ActionEvent event) {try {  // Load Scene2 using absolute path
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
    void goinventory(ActionEvent event) {
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
    void gomenu(ActionEvent event) {try {  // Load Scene2 using absolute path
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
    void goserver(ActionEvent event) {
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

    @FXML
    void logout(ActionEvent event) {try {  // Load Scene2 using absolute path
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
    }}
    private final ObservableList<Stock> data = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { /*Orderid.setCellValueFactory(new PropertyValueFactory<>("productId"));
        ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        QuantityName.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        SSupplierid.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        SupplierNom.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        NumeroTlf.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        CompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        // Example data
        data.add(new Stock(1, "Widget", "SupplierName", 5551234, "WidgetCorp"));
        data.add(new Stock(2, "Gadget", "SupplierTwo", 5555678, "GadgetCorp"));

        // Link data to TableView
        tableview.setItems(data);
*/
    }
    @FXML
    void filtrer(ActionEvent event) {

      String filterText = gettext.getText();
        List<Stock> cu =  all.getStocks().stream()
                .filter(Stock -> Stock.getNom().equalsIgnoreCase(filterText))
                .collect(Collectors.toList());
        tableview.setItems(FXCollections.observableArrayList());
        ObservableList<Stock> customerList = FXCollections.observableArrayList(cu);
        tableview.setItems(customerList);
    }
}
