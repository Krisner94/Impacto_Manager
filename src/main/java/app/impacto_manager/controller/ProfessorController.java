package app.impacto_manager.controller;

import app.impacto_manager.util.SystemWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

@Controller
@FxmlView("fxml/new/teacher.fxml")
public class ProfessorController {
    private SystemWindow window;
    @FXML
    private void onButtonCloseClicked(ActionEvent event) {
        window.fecharJanela(event);
    }

}
