package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.ALL;
import com.cafe.models.Server;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EmployeeController implements table {

    @FXML
    private Button CLEARSERVER;

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCLOSE;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBOARD;

    @FXML
    private Button GODELETESERVER;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOLOGOUT;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GOSERVER;

    @FXML
    private Button GOUPDATESERVER;
    @FXML
    private Button GOUPDATESERRVER;

    @FXML
    private TableColumn<Server, String> Server;

    @FXML
    private TableView<Server> TABLESERVER;

    @FXML
    private TableColumn<Server, String > adresse;

    @FXML
    private TableColumn<Server, String> date;

    @FXML
    private TableColumn<Server, Double> sal;

    @FXML
    private TableColumn<Server, Integer> tables;

    @FXML
    private TableColumn<Server, Integer> tlf;

    private ALL all;

    public void setAll(ALL all) {

        this.all = all;
        if (all.getServers().isEmpty()) System.out.println("there s nothing to show ");
        else populatetable();
    }
    @Override
    public void populatetable() {
        if (TABLESERVER == null) {
            System.err.println("TABLESERVER is null. Check if the FXML is loaded properly.");
            return;
        }

        try {
            // Bind columns to fields
            Server.setCellValueFactory(new PropertyValueFactory<>("nom"));
            adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
            date.setCellValueFactory(new PropertyValueFactory<>("date_embauche"));
            sal.setCellValueFactory(new PropertyValueFactory<>("salaire"));
            tables.setCellValueFactory(new PropertyValueFactory<>("table"));
            tlf.setCellValueFactory(new PropertyValueFactory<>("telephone"));

            // Populate TableView with the ObservableList of server data
            ObservableList<Server> serverList = FXCollections.observableArrayList(all.getServers());
            TABLESERVER.setItems(serverList);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the server table view.");
        }
    }
    @FXML
    void GODASHBOARD(ActionEvent event) throws IOException {
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
    void addserver(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Add-Employee.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            AddEmployeeController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gochef(ActionEvent event) throws IOException {
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
    void gocustomers(ActionEvent event) throws IOException {
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

    @FXML
    void goinventory(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\INVENTORY.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            INVENTORYCONTROLLER controller = loader.getController();
            controller.setAll(all);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gologout(ActionEvent event) throws IOException {
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
    void gomenu(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\MENU.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            MenuController controller = loader.getController();
            controller.setAll(all);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goserver(ActionEvent event) throws IOException {
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
    void updateserver(ActionEvent event) throws IOException {
        boolean fc;
        fc = all.getServers().isEmpty();
        if (fc) System.out.println("theres nothing to update");
        else {

        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Update-Employee.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            UpdateEmployeeController controller = loader.getController();
            controller.setAll(all);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }}
    }


    public void tableserver(SortEvent<TableView<?>> tableViewSortEvent) {
    }

    public void clearserver(ActionEvent actionEvent) {
        all.getServers().clear();
    }

    public void deleteserver(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Delelete-Server.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            DeleteServerController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goclose(ActionEvent actionEvent) {
        Platform.exit();
    }
}
