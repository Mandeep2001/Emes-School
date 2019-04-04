package it.emes.schoolmanagement.util.alert;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ALertController implements Initializable {

    @FXML
    private AnchorPane main_pane;
    @FXML
    private Label titleLabel;
    @FXML
    private Label messageLabel;

    private double x = 0;
    private double y = 0;

    private String title;
    private String message;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeDraggable();
        titleLabel.setText(title);
        messageLabel.setText(message);
    }

    public void setup() {
        System.out.println("fcefpe");
        titleLabel.setText(title);
        messageLabel.setText(message);
    }

    public void makeDraggable() {
        main_pane.setOnMousePressed((event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        }));

        main_pane.setOnMouseDragged(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }

    @FXML
    public void close() {
        Stage stage = (Stage) main_pane.getScene().getWindow();
        stage.close();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
