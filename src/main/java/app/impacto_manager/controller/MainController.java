package app.impacto_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.io.IOException;

@Controller
@FxmlView("fxml/Main.fxml")
public class MainController {
    @FXML
    private MenuItem menuItem_students;
    @FXML
    private MenuItem menuItem_professor;
    @FXML
    private MenuItem menu_turma;

    @FXML
    private AnchorPane anchorPane_views;

    @FXML
    private void initialize() {

    }

    @FXML
    private void openStudentOnMouseClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/aluno.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        anchorPane_views.getChildren().clear();
        anchorPane_views.getChildren().add(root);
    }
}
