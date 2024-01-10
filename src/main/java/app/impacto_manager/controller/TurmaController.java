package app.impacto_manager.controller;

import app.impacto_manager.util.SystemWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

@Controller
@FxmlView("/fxml/classroom.fxml")
public class TurmaController {
    @FXML
    private void onButtonCloseClicked(ActionEvent event) {
        SystemWindow.fecharJanela(event);
    }
}
