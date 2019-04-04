package it.emes.schoolmanagement.client.staffer.controllers;

import it.emes.schoolmanagement.client.network.RequestService;
import it.emes.schoolmanagement.client.staffer.models.MainModel;
import it.emes.schoolmanagement.library.network.Request;
import it.emes.schoolmanagement.library.network.RequestBuilder;
import it.emes.schoolmanagement.library.network.RequestType;
import it.emes.schoolmanagement.library.network.Response;
import it.emes.schoolmanagement.library.school.SchoolClass;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.UserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentiController implements Initializable {

    @FXML private Label numStudentiLabel;
    @FXML private TabPane tabPane;
    @FXML private Tab addTab;
    @FXML private Tab updateTab;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField usernameField;
    @FXML private ComboBox<String> classComboBox;
    @FXML private TextField studentSearchField;
    @FXML private Label studentIDLabel;
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label usernameLabel;
    @FXML private Label studentClassLabel;

    private MainModel model;
    private ObservableList<String> schoolClasses = FXCollections.observableArrayList();
    private String schoolClass;
    private RequestBuilder requestBuilder;
    private RequestService requestService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void setup() {
        numStudentiLabel.setText(String.valueOf(model.getSchool().getStudents().size()));
        for (SchoolClass sc : model.getSchool().getSchoolClasses()) {
            schoolClasses.add(sc.getName());
        }
        classComboBox.setItems(schoolClasses);
        classComboBox.valueProperty().addListener((o, n, v) -> {
            schoolClass = v;
        });
        studentIDLabel.setText("");
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        usernameLabel.setText("");
        studentClassLabel.setText("");
    }

    @FXML
    public void addStudent() {
        model.addStudent( firstNameField.getText(), lastNameField.getText(), usernameField.getText(), schoolClass);
        refresh();
    }

    @FXML
    public void searchStudent() {
        requestBuilder = new RequestBuilder(RequestType.GET_USER)
                .setStudent(new Student(studentSearchField.getText(), ""))
                .setUserType(UserType.STUDENT);
        requestService = new RequestService(requestBuilder.build());
        requestService.setOnSucceeded(event -> {
            Response response = requestService.getValue();
            if (response.getResult() == 0) {
                model.setStudent((Student) response.getUser());;
                studentIDLabel.setText(String.valueOf(model.getStudent().getID()));
                firstNameLabel.setText(model.getStudent().getFirstname());
                lastNameLabel.setText(model.getStudent().getLastname());
                usernameLabel.setText(model.getStudent().getUsername());
                studentClassLabel.setText(model.getStudent().getSchoolClass().getName());
            } else if (response.getResult() == 1) {
                System.out.println("Studente non trovato.");
            } else {
                System.err.println("Errore durante la ricerca dello studente.");
            }
            refresh();
        });
        requestService.start();
    }

    @FXML
    public void deleteStudent() {
        requestBuilder = new RequestBuilder(RequestType.DELETE_USER)
                .setUserType(UserType.STUDENT)
                .setUser(model.getStudent());
        requestService = new RequestService(requestBuilder.build());
        requestService.setOnSucceeded(event -> {
            if (requestService.getValue().getResult() == 0) {
                model.getSchool().setStudents(requestService.getValue().getSchool().getStudents());
                System.out.println(requestService.getValue().getResult());
                System.out.println("Operazione riuscita.");
            }
            else
                System.err.println("Operazione fallita.");
            refresh();
        });
        requestService.start();
    }

    @FXML
    public void showUpdateTab() {
        tabPane.getSelectionModel().select(updateTab);
        System.out.println(model.getStudent());
    }

    @FXML
    public void updateStudent() {
        requestBuilder = new RequestBuilder(RequestType.UPDATE_USER)
                .setStudent(model.getStudent())
                .setStaffer(model.getStaffer())
                .setUserType(UserType.STUDENT);
        requestService = new RequestService(requestBuilder.build());
        requestService.setOnSucceeded(event -> {
            System.out.println(requestService.getValue().getResult());
        });
    }

    private void refresh() {
        numStudentiLabel.setText(String.valueOf(model.getSchool().getStudents().size()));
    }

    void setModel(MainModel model) {
        this.model = model;
    }
}
