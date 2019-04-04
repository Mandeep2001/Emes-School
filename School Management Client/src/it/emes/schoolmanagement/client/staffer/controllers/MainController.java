package it.emes.schoolmanagement.client.staffer.controllers;

import it.emes.schoolmanagement.client.staffer.models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private BorderPane main_pane;

    private MainModel model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void studentiScene() {
        loadScene("/it/emes/schoolmanagement/client/staffer/views/studentiView.fxml");
    }

    private void loadScene(String path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        try {
            Node node = loader.load();
            StudentiController controller = loader.getController();
            controller.setModel(model);
            main_pane.setCenter(node);
            controller.setup();
        } catch (IOException ex) {
            System.err.println("Errore durante il caricamento della scena.. " + ex.getMessage());
        }
    }

    public MainModel getModel() {
        return model;
    }

    public void setModel(MainModel model) {
        this.model = model;
    }
}
