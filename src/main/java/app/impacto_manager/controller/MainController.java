package app.impacto_manager.controller;

import app.impacto_manager.enums.Gender;
import app.impacto_manager.model.Student;
import app.impacto_manager.service.aluno.AlunoService;
import app.impacto_manager.util.SystemWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import static app.impacto_manager.util.SystemWindow.openWindowInSameStage;

@Component
@Controller
@FxmlView("fxml/main.fxml")
@RequiredArgsConstructor
public class MainController {
    private final AlunoService service;

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Student> tableView_dataStudents;
    @FXML
    private TableColumn<Student, Long> colum_id;
    @FXML
    private TableColumn<Student, String> column_name;
    @FXML
    private TableColumn<Student, String> column_gender;
    @FXML
    private TableColumn<Student, String> column_phone;
    @FXML
    private TableColumn<Student, String> column_cpf;
    @FXML
    private TableColumn<Student, Button> column_edit;
    @FXML
    private TableColumn<Student, Button> column_delete;

    @FXML
    private void initialize() {
        colum_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_cpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        service.initializeTableRows(column_edit,column_delete);
        tabelaAlunosMock();
    }


    private void tabelaAlunosMock() {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        studentList.setAll(
                new Student("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "12241612626"),
                new Student("Rhama Krisner Davidson", Gender.MASCULINO, "(31)99902-0564", "12241612626"),
                new Student("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "12241612626")
        );

        studentList.add(new Student("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "12241612626"));

        tableView_dataStudents.getItems().addAll(
                studentList
        );

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
        String uri = "/fxml/mais/configurations.fxml";
        String title = "Turmas";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    private void openWindowAndClearPane() {
        Pane pane = openWindowInSameStage("/fxml/main.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }
    @FXML
    private void onMenuItemSobreClick(){
        String url = "/fxml/mais/sobre.fxml";
        SystemWindow.openWindowInOtherStage(url, "Sobre", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void onMenuConfiguracaoClick(){
        String url = "/fxml/mais/configurations.fxml";
        SystemWindow.openWindowInOtherStage(url, "Configuracoes", false, Modality.WINDOW_MODAL);
    }




}
