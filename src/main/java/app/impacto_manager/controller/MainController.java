package app.impacto_manager.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import java.awt.*;

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
    private AnchorPane anchorPane_views;

    @FXML
    private void initialize() {

    }

    @FXML
    private void openStudentOnMouseClick() {
        Pane pane = (Pane) abrirJanela("/fxml/studens.fxml");
        anchorPane_views.getChildren().clear();
        anchorPane_views.getChildren().add(pane);
    }
    @FXML
    private void openTeacherOnMouseClick(){
        Pane pane = (Pane) abrirJanela("/fxml/teacher.fxml");
        anchorPane_views.getChildren().clear();
        anchorPane_views.getChildren().add(pane);
    }
    @FXML
    private void openClassroomOnMouseClick(){
        Pane pane = (Pane) abrirJanela("/fxml/classroom.fxml");
        anchorPane_views.getChildren().clear();
        anchorPane_views.getChildren().add(pane);
    }

}
