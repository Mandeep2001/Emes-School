package it.emes.schoolmanagement.client.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginLoader extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
        AnchorPane root = fxmlLoader.load();
        stage.setScene(new Scene(root));

        LoginController controller = fxmlLoader.getController();
        LoginModel model = new LoginModel();
        controller.setModel(model);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
