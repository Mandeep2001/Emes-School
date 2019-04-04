package it.emes.schoolmanagement.client.login;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import it.emes.schoolmanagement.client.network.RequestService;
import it.emes.schoolmanagement.client.staffer.controllers.MainController;
import it.emes.schoolmanagement.client.staffer.models.MainModel;
import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.RequestBuilder;
import it.emes.schoolmanagement.library.network.RequestType;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.library.users.UserType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private AnchorPane main_pane;
    @FXML private TextField user_field;
    @FXML private PasswordField pass_field;
    @FXML private ComboBox<UserType> userType_comboBox;
    @FXML private Label register_label;
    @FXML private Label loginError_label;
    @FXML private FontAwesomeIconView close_button;

    private double off_x = 0;
    private double off_y = 0;
    private LoginModel model;
    private UserType userType;
    private ObservableList<UserType> userTypes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setup();
    }

    private void setup() {
        makeDraggable();
        userTypes.addAll(Arrays.asList(UserType.values()));
        userType_comboBox.setItems(userTypes);
        userType_comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            userType = newValue;
        });
    }

    private void makeDraggable() {
        main_pane.setOnMousePressed((event -> {
            off_x = event.getSceneX();
            off_y = event.getSceneY();
        }));

        main_pane.setOnMouseDragged(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setX(event.getScreenX() - off_x);
            stage.setY(event.getScreenY() - off_y);
        });
    }

    /**
     * Metodo per uscire dal programma
     */
    @FXML
    public void closeApp() {
        Stage stage = (Stage) main_pane.getScene().getWindow();
        stage.close();
    }

    /**
     * Login method.
     * Questo metodo viene invocato quando l'utente prova ad accedere.
     * Alla chiamata di questo metodo viene creato un utente con username e password inseriti,
     * lo user creato viene inviato al server per effettuare il controllo delle credenziali, il
     * server invia una Response contenente il risultato del login, in base a ciò il programma
     * sceglie se far accedere oppure stampare un messaggio d'errore.
     */
    @FXML
    public void login() {
        User user = new User(user_field.getText(), pass_field.getText());
        RequestBuilder requestBuilder = new RequestBuilder(RequestType.LOGIN)
                .setUser(user)
                .setUserType(userType);
        RequestService loginRequest = new RequestService(requestBuilder.build());
        loginRequest.setOnSucceeded(event -> {
            Response response = loginRequest.getValue();
            model.setUser(response.getUser());
            switch (response.getResult()) {
                case 0:
                    System.out.println("Login avvenuto con successo.");
                    loadMain(userType);
                    break;
                case -1:
                    System.out.println("Credenziali errate.");
                    break;
                default:
                    System.out.println("Errore durante il login.");
                    break;
            }
        });
        loginRequest.start();
    }

    void setModel(LoginModel model) {
        this.model = model;
    }

    private void loadMain(UserType userType) {
        switch (userType) {
            case STAFF:
                loadScene("/it/emes/schoolmanagement/client/staffer/views/mainView.fxml");
                closeApp();
                break;
            case TEACHER:
                break;
            case STUDENT:
                break;
                default:
                    System.out.println("Tipo utente sconosciuto: " + userType);
        }
    }

    private void loadScene(String path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root;
        try {
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            MainController controller = loader.getController();
            controller.setModel(new MainModel((Staffer) model.getUser(), model.getSchool()));
            stage.sizeToScene();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("EMES School");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
