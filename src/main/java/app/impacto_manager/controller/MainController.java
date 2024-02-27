package app.impacto_manager.controller;

import app.impacto_manager.model.Student;
import app.impacto_manager.service.aluno.AlunoService;
import app.impacto_manager.service.main.MainService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
@FxmlView("fxml/main.fxml")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    private final AlunoService alunoService;

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
        mainService.initializeTableRows(column_edit,column_delete, tableView_dataStudents);
    }


    @FXML
    private void openStudentOnMouseClick() {
        alunoService.addStudentStage();
    }

    @FXML
    private void openTeacherOnMouseClick() {
    }

    @FXML
    private void openClassroomOnMouseClick() {
    }

    @FXML
    private void openSeeStudentsOnMouseClick() {
        openWindowAndClearPane();
    }

    @FXML
    private void openSeeTeacherOnMouseClick() {

    }

    @FXML
    private void openSeeClassroomOnMouseClick() {

    }

    @FXML
    private void openConfigOnMouseClick() {

    }

    private void openWindowAndClearPane() {

    }
    @FXML
    private void onMenuItemSobreClick(){

    }

    @FXML
    private void onMenuConfiguracaoClick(){
    }
}
