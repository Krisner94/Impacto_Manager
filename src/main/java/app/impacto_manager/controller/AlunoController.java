package app.impacto_manager.controller;

import app.impacto_manager.util.SystemWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;


@Controller
@FxmlView("fxml/studens.fxml")
public class AlunoController {
    @FXML
    private Button button_add;

    @FXML
    private Button button_close;
    @FXML
    private void onButtonCloseClicked(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        SystemWindow.fecharJanela(stage);
    }
}
