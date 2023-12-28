package app.impacto_manager.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
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
    private AnchorPane pane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TableView tableView_data;

    @FXML
    private void initialize() {
        PaneConfig(tableView_data);
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

    @FXML
    private void openSeeStudentsOnMouseClick() {
        Pane pane = (Pane) abrirJanela("/fxml/Main.fxml");

        // Defina as âncoras do pane para preencher completamente o AnchorPane
        PaneConfig(pane);

        if (!pane.getChildren().contains(menuBar)) {
            pane.getChildren().add(0, menuBar);
        }

        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    private void PaneConfig(Node object) {
        AnchorPane.setTopAnchor(object, 0.0);
        AnchorPane.setBottomAnchor(object, 0.0);
        AnchorPane.setLeftAnchor(object, 0.0);
        AnchorPane.setRightAnchor(object, 0.0);
    }

}
