package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import com.cafe.models.Chef;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeleteChefController implements com.Interfaces.ComboBox {

    @FXML
    private ComboBox<String> CHOISIR;

    @FXML
    private Button DELETECHEF;

    @FXML
    private Button GOCHEF;

    private ALL all;

    public void setAll(ALL all) {

        this.all = all;
        populateComboBox();

    }

    @FXML
    void combobox(ActionEvent event) {

    }
    @Override
    public void populateComboBox() {
        if (CHOISIR == null) {
            System.err.println("ComboBox is null, check your FXML.");
            return;
        }

        CHOISIR.getItems().clear();
        if (all != null && all.getChefs() != null) {
            for (Chef chef : all.getChefs()) {
                System.out.println("Loading server into combo box: " + chef.getNom());
                CHOISIR.getItems().add(chef.getNom());
            }
        } else {
            System.err.println("No chef or all instance is null.");
        }
    }
    @FXML
    void delete(ActionEvent event) {
        int num = CHOISIR.getSelectionModel().getSelectedIndex();
        if (num == -1) System.out.println("No server selected.");
        else all.getChefs().remove(num);

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
