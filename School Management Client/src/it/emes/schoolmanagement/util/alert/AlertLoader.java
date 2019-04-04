package it.emes.schoolmanagement.util.alert;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AlertLoader {

    private Stage stage;

    public AlertLoader(String title, String message) {
        try {
            load(title, message);
        } catch (IOException e) {
            System.err.println("Errore durante il load dell'alert.");
        }
    }

    private void load(String title, String message) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AlertView.fxml"));
        AnchorPane root = loader.load();
        stage = new Stage();
        ALertController controller = loader.getController();
        controller.setTitle(title);
        controller.setMessage(message);
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

}
