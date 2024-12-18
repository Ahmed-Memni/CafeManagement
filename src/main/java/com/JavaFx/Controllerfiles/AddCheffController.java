package com.JavaFx.Controllerfiles;

import com.Exceptions.ArgumentInvalideException;
import com.cafe.models.ALL;
import com.cafe.models.Chef;
import com.cafe.models.OrderItem;
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

public class AddCheffController {

    @FXML
    private TextField Create_Adresse;

    @FXML
    private Button Create_Chef;

    @FXML
    private TextField Create_Date;

    @FXML
    private TextField Create_Name;

    @FXML
    private TextField Create_NameOrder;

    @FXML
    private TextField Create_Prenom;

    @FXML
    private TextField Create_Price;

    @FXML
    private TextField Create_Salaire;

    @FXML
    private TextField Create_Tlf;

    @FXML
    private Button GOTOCHEF;

    @FXML
    private AnchorPane Si_Create;

    @FXML
    private AnchorPane Si_Login;

    @FXML
    private AnchorPane always;

    private ALL all;



    public void setAll(ALL all) {
        this.all = all;
    }

    @FXML
    void createChef(ActionEvent event) throws ArgumentInvalideException {
        String nom = Create_Name.getText();
        String prenom = Create_Prenom.getText();
        double sal = Double.parseDouble(Create_Salaire.getText());
        String Date = Create_Date.getText();
        Integer tlf = Integer.parseInt(Create_Tlf.getText());
        String adresse = Create_Adresse.getText();
        String order = Create_NameOrder.getText();
        double price = Double.parseDouble(Create_Price.getText());

        OrderItem orderr = new OrderItem(order, 1, price);
        Chef chef = new Chef(1,nom,prenom,tlf,adresse,sal,Date,orderr);
        all.addChef(chef);
        all.addOrderItem(orderr);
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        try {
            // Load Scene2 using absolute path
            FXMLLoader loader = new FXMLLoader();
            File fxmlFile = new File("C:\\Users\\memni\\IdeaProjects\\CafeManagement\\src\\main\\java\\com\\JavaFx\\fxmlfiles\\Chef.fxml");
            loader.setLocation(fxmlFile.toURI().toURL());

            Parent root = loader.load();

            // Pass ALL to the next controller
            ChefController controller = loader.getController();
            controller.setAll(all);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
