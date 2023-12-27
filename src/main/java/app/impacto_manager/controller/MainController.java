package app.impacto_manager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import static app.impacto_manager.util.NewWindow.abrirJanela;

@Controller
@FxmlView("fxml/Main.fxml")
public class MainController {
    @FXML
    private MenuItem menuItem_students;
    @FXML
    private MenuItem menuItem_teacher;
    @FXML
    private MenuItem menuItem_classroom;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView tableView_data;



    @FXML
    private void initialize() {
        // Defina as âncoras do TableView para preencher completamente o AnchorPane
        AnchorPane.setTopAnchor(tableView_data, 0.0);
        AnchorPane.setBottomAnchor(tableView_data, 0.0);
        AnchorPane.setLeftAnchor(tableView_data, 0.0);
        AnchorPane.setRightAnchor(tableView_data, 0.0);
    }

    @FXML
    private void openStudentOnMouseClick() {
        Pane pane = (Pane) abrirJanela("/fxml/studens.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    @FXML
    private void openTeacherOnMouseClick() {
        Pane pane = (Pane) abrirJanela("/fxml/teacher.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    @FXML
    private void openClassroomOnMouseClick() {
        Pane pane = (Pane) abrirJanela("/fxml/classroom.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }


}
