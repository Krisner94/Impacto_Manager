package app.impacto_manager.controller;

import app.impacto_manager.data.Students;
import app.impacto_manager.util.SystemWindow;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    }

    @FXML
    private void openStudentOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/studens.fxml", "Novo Aluno", false, Modality.APPLICATION_MODAL);


    }

    @FXML
    private void openTeacherOnMouseClick() {
        Pane pane = openWindowInSameStage("/fxml/teacher.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    @FXML
    private void openClassroomOnMouseClick() {
        Pane pane = openWindowInSameStage("/fxml/classroom.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    @FXML
    private void openSeeStudentsOnMouseClick() {
        Pane pane = openWindowInSameStage("/fxml/main.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

}
