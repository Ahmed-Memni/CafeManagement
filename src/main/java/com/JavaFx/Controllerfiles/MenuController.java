package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.ALL;
import com.cafe.models.Customer;
import com.cafe.models.Order;
import com.cafe.models.OrderItem;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController implements table, com.Interfaces.ComboBox {
    private ALL all;


    public void setAll(ALL all) {
        this.all = all;
        populatetable();
    }

    @FXML
    private Button ADDorder;
    @FXML
    private Button resetorder;

    @FXML
    private TextField Addprice;

    @FXML
    private ComboBox<String> CHOIsircustomer;

    @FXML
    private Button Dlete;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GOChef;

    @FXML
    private Button GODASHBOARD;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GoLOG;

    @FXML
    private Button Goclose;

    @FXML
    private Button Goserver;

    @FXML
    private TextField look;

    @FXML
    private Button clear;

    @FXML
    private TableColumn<OrderItem, String> name;

    @FXML
    private TextField ordername;

    @FXML
    private TableColumn<OrderItem, Double> price;

    @FXML
    private Button receit;

    @FXML
    private TableView<OrderItem> tableview;

    @FXML
    private TableView<OrderItem> tablevieworders;

@Override
    public void populatetable() {
        if (tablevieworders == null) {
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
            tablevieworders.setItems(itemsList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the table view.");
        }
    }

    @FXML
    void AFFICHERRECIET(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {
    populatetable();

    }
    @FXML
    void Search(ActionEvent event) {
        List<OrderItem> cu =  all.getItems().stream()
                .filter(OrderItem -> OrderItem.getName().equalsIgnoreCase(look.getText()))
                .collect(Collectors.toList());
        tablevieworders.setItems(FXCollections.observableArrayList());
        ObservableList<OrderItem> customerList = FXCollections.observableArrayList(cu);
        tablevieworders.setItems(customerList);

    }

    @FXML
    void addorder(ActionEvent event) {
        String order = ordername.getText();
        double price = Double.parseDouble(Addprice.getText());

        OrderItem orderr = new OrderItem(order, 1, price);
        all.getItems().add(orderr);
        populatetable();

    }

    @Override
    public void populateComboBox(){System.out.println("ff");}
    @FXML
    void choixcustomer(ActionEvent event) {

    }

    @FXML
    void clearorders(ActionEvent event) {
        all.getItems().clear();
        populatetable();

    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void delteorder(ActionEvent event) {
        String order = ordername.getText();
        double price = Double.parseDouble(Addprice.getText());

        OrderItem orderr = new OrderItem(order, 1, price);
        all.getItems().remove(orderr);
        populatetable();

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
            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Login.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            LoginController controller = loader.getController();
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

    @FXML
    void tableview(ActionEvent event) {

    }

    @FXML
    void tablevieworders(ActionEvent event) {

    }

}
