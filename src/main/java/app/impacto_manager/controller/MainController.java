package app.impacto_manager.controller;

import app.impacto_manager.model.Students;
import app.impacto_manager.util.SystemWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import static app.impacto_manager.util.SystemWindow.openWindowInSameStage;

@Controller
@FxmlView("fxml/main.fxml")
public class MainController {
    @FXML
    private AnchorPane pane;
    @FXML
    private MenuBar menuBar;
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
    private void initialize() {
        colum_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        addDataOnTable();
    }

    private void addDataOnTable() {
        ObservableList<Students> students = FXCollections.observableArrayList();

        students.add(new Students(1L, "Rhama Krisner", "Masculino", "123456789", "11122233344"));
        students.add(new Students(2L, "Josiane Aparecida", "Feminino", "987654321", "44433322211"));

        tableView_dataStudents.setItems(students);
    }


    @FXML
    private void openStudentOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/studens.fxml", "Novo Aluno", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openTeacherOnMouseClick(){
        SystemWindow.openWindowInOtherStage("/fxml/teacher.fxml", "Novo professor", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openClassroomOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/classroom.fxml", "Nova Turma", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openSeeStudentsOnMouseClick() {
        openWindowAndClearPane("/fxml/main.fxml");
    }

    private void openWindowAndClearPane(String fxmlPath) {
        Pane pane = openWindowInSameStage(fxmlPath);
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

}
