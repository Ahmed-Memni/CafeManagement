package com.JavaFx.Controllerfiles;

import com.Interfaces.table;
import com.cafe.models.ALL;
import com.cafe.models.Chef;
import com.sun.scenario.effect.Identity;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
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

import static java.lang.System.out;

public class ChefController implements table {

    public javafx.scene.control.TableView TableView;
    @FXML
    private Button CLOSE;

    @FXML
    private Button GOADDCHEF;

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCLEARCHEF;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBORD;

    @FXML
    private Button GODELETE;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOLOGOUT;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GOSERVER;

    @FXML
    private Button GOUPDATE;


    @FXML
    private TableColumn<Chef, String> adrcol;

    @FXML
    private TableColumn<Chef, String> dateCol;

    @FXML
    private TableColumn<Chef, String > nameColumn;

    @FXML
    private TableColumn<Chef, Integer> numCol;

    @FXML
    private TableColumn<Chef, Integer> salaireCol;

    @FXML
    private TableColumn<Chef, String> specialiteCol;



    private ALL all;

    public void setAll(ALL all) {
        this.all = all;
        populatetable();
    }
    @Override
    public void populatetable() {
        if (TableView == null) {
            System.err.println("TABLEVIEW is null. Check if the FXML is loaded properly.");
            return;
        }

        try {
            // Bind columns to fields
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            numCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            salaireCol.setCellValueFactory(new PropertyValueFactory<>("salaire"));
            adrcol.setCellValueFactory(new PropertyValueFactory<>("address"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date_embauche"));
            specialiteCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));




            ObservableList<Chef> serverList = FXCollections.observableArrayList(all.getChefs());
            TableView.setItems(serverList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to populate the table view.");
        }
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Delete-Chef.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            DeleteChefController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goadd(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Add-Chef1.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            AddCheffController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void goclear(ActionEvent event) {
        all.getChefs().clear();
        populatetable();
    }

    @FXML
    void goclose(ActionEvent event) {
        Platform.exit();
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

    @FXML
    void gologout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Create.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            LoginController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goinventory(ActionEvent event) {
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
    void godashboard(ActionEvent event) {
        try {  // Load Scene2 using absolute path
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

    public void table(SortEvent<TableView<?>> tableViewSortEvent) {
    }

    public void goupdate(ActionEvent actionEvent) {
       boolean fc;
       fc = all.getChefs().isEmpty();
       if (fc) System.out.println("theres nothing to update");
       else {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Update-Chef.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            UpdateChefController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }}
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

    public void goserver(ActionEvent actionEvent) {
        try {  // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();
            EmployeeController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
import com.cafe.models.Chef;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.File;

import javafx.scene.control.TextField;

public class ChefController {
    @FXML
    private Button CLOSE;

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
    private TextField id;

    @FXML
    private TextField idd;

    @FXML
    private TextField name;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TableView<Chef> tableview;

    @FXML
    private TextField tlf;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void combobox(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void gochef(ActionEvent event) { try {  // Load Scene2 using absolute path
        File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Chef.fxml"); // Replace with the actual path
        Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

        // Get current stage and set new scene
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (Exception e) {
        e.printStackTrace();
    }


    }

    @FXML
    void goclos(ActionEvent event) {

    }

    @FXML
    void gocustomers(ActionEvent event) {  try {  // Load Scene2 using absolute path
        File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Customer.fxml"); // Replace with the actual path
        Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

        // Get current stage and set new scene
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (Exception e) {
        e.printStackTrace();
    }


    }

    @FXML
    void godashboard(ActionEvent event) {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\DASHBORD.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\INVENTORY.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void gomenu(ActionEvent event) {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\MENU.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void logout(ActionEvent event) { try {  // Load Scene2 using absolute path
        File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Login.fxml"); // Replace with the actual path
        Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

        // Get current stage and set new scene
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (Exception e) {
        e.printStackTrace();
    }


    }

    @FXML
    void update(ActionEvent event) {

    }


}















import com.cafe.models.Chef;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChefController implements Initializable {


    @FXML
    private Button Clear;

    @FXML
    private Button GOADDCheff;

    @FXML
    private Button GOCHEF;

    @FXML
    private Button GOCLOSE;

    @FXML
    private Button GOCUSTOMERS;

    @FXML
    private Button GODASHBOARD;

    @FXML
    private Button GODELETE;

    @FXML
    private Button GOINVENTORY;

    @FXML
    private Button GOLOGOUT;

    @FXML
    private Button GOMENU;

    @FXML
    private Button GOSERVER;

    @FXML
    private Button GOUPDATECHEF;

    @FXML
    private Button SI_FEEDBACKS;

    @FXML
    private TableColumn<Chef, String> adrcol;

    @FXML
    private TableColumn<Chef, String> dateCol;

    @FXML
    private TableColumn<Chef, Integer> idColumn;

    @FXML
    private TableColumn<Chef, String> nameColumn;

    @FXML
    private TableColumn<Chef, Integer> numCol;

    @FXML
    private TableColumn<Chef,Double> salaireCol;

    @FXML
    private TableColumn<Chef, String> specialiteCol;

    @FXML
    private TableView<Chef> tableView;


    final ObservableList<Chef> chefs = FXCollections.observableArrayList();

    //table view pour afficher les chefs
    TableView<Chef> tabView = new TableView<Chef>();


    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void goaddchef(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Add-Chef1.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void gochef(ActionEvent event) throws IOException {

    }

    @FXML
    void gocustomers(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Customer.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\DASHBORD.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void godeletechef(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Delete-Chef.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\INVENTORY.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\MENU.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

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
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Employee.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goupdatechef(ActionEvent event) throws IOException {
        try {  // Load Scene2 using absolute path
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\UpdateChefController.fxml"); // Replace with the actual path
            Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

            // Get current stage and set new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
      try {  // Load Scene2 using absolute path
        File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Login.fxml"); // Replace with the actual path
        Parent root = FXMLLoader.load(fxmlFile.toURI().toURL());

        // Get current stage and set new scene
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chefs.addAll(
                new Chef(0,"John", "Doe", 11111111, "bizert", 123, "123 Main St"),
                new Chef(0,"John", "Doe", 11111111, "bizert", 123, "123 Main St"),
                new Chef(0,"John", "Doe", 11111111, "bizert", 123, "123 Main St")
        );

        // Bind table columns to Chef properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Updated to 'nom'
        adrcol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("tlf")); // Updated to 'tlf'
        salaireCol.setCellValueFactory(new PropertyValueFactory<>("sal")); // Updated to 'sal'
        specialiteCol.setCellValueFactory(new PropertyValueFactory<>("specialities")); // Shows specialities as needed

        // Set the data into the table view
        tableView.setItems(chefs);

    }*/
