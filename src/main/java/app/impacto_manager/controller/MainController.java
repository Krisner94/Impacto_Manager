package app.impacto_manager.controller;

import app.impacto_manager.model.Students;
import app.impacto_manager.repository.StudentsRepository;
import app.impacto_manager.util.SystemWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

import static app.impacto_manager.util.SystemWindow.openWindowInSameStage;
@Component
@Controller
@FxmlView("fxml/main.fxml")
public class MainController {
    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Students> tableView_dataStudents = new TableView<>();
    @FXML
    private TableColumn<Students, Long> colum_id;
    @FXML
    private TableColumn<Students, String> column_name;
    @FXML
    private TableColumn<Students, String> column_gender;
    @FXML
    private TableColumn<Students, String> column_phone;
    @FXML
    private TableColumn<Students, String> column_cpf;

    @FXML
    private Menu menu_config;

    @Autowired
    private StudentsRepository studentsRepository;


    @FXML
    private void initialize() {
        colum_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        addDataOnTable();
    }

    private void addDataOnTable() {
//        ObservableList<Students> students = FXCollections.observableArrayList();
//
//        students.add(new Students(1L, "Rhama Krisner", "Masculino", "123456789", "11122233344"));
//        students.add(new Students(2L, "Josiane Aparecida", "Feminino", "987654321", "44433322211"));
//
//        tableView_dataStudents.setItems(students);

        List<Students> students = studentsRepository.findAll();
        ObservableList<Students> observableStudents = FXCollections.observableArrayList(students);
        tableView_dataStudents.setItems(observableStudents);
    }


    @FXML
    private void openStudentOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/studens.fxml", "Novo Aluno", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openTeacherOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/teacher.fxml", "Novo professor", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openClassroomOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/classroom.fxml", "Nova Turma", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openSeeStudentsOnMouseClick() {
        openWindowAndClearPane();
    }

    @FXML
    private void openSeeTeacherOnMouseClick() {
        String uri = "/fxml/see/teacher.fxml";
        String title = "Professores";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    @FXML
    private void openSeeClassroomOnMouseClick() {
        String uri = "/fxml/see/classroom.fxml";
        String title = "Turmas";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    @FXML
    private void openConfigOnMouseClick() {
        String uri = "/fxml/configurations/configurations.fxml";
        String title = "Turmas";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    private void openWindowAndClearPane() {
        Pane pane = openWindowInSameStage("/fxml/main.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

}
