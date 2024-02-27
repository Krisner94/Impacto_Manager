package app.impacto_manager.controller.mais;

import app.impacto_manager.util.SystemWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
@FxmlView("/fxml/mais/sobre.fxml")
public class SobreController {
    private SystemWindow window;
    @FXML
    private void onButtonFecharClicked(ActionEvent event) {
        window.fecharJanela(event);
    }
}
