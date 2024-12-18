package com.JavaFx.Controllerfiles;

import com.cafe.models.ALL;
import com.cafe.models.Chef;
import com.cafe.models.Server;
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

public class DeleteServerController implements com.Interfaces.ComboBox {
    private ALL all;

    public void setAll(ALL all) {
        this.all = all;
        populateComboBox();
    }
    @Override
    public void populateComboBox() {
        if (CHOISIRSERVER == null) {
            System.err.println("ComboBox is null, check your FXML.");
            return;
        }

        CHOISIRSERVER.getItems().clear();
        if (all != null && all.getChefs() != null) {
            for (Server server : all.getServers()) {
                System.out.println("Loading server into combo box: " + server.getNom());
                CHOISIRSERVER.getItems().add(server.getNom());
            }
        } else {
            System.err.println("No chef or all instance is null.");
        }
    }

    @FXML
    private ComboBox<String> CHOISIRSERVER;

    @FXML
    private Button DELETESERVER;

    @FXML
    private Button GOSERVER;

    @FXML
    void deleteserver(ActionEvent event) {
        int num = CHOISIRSERVER.getSelectionModel().getSelectedIndex();
        if (num == -1) System.out.println("No server selected.");
        else all.getServers().remove(num);
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
}
