package app.impacto_manager.controller;

import app.impacto_manager.enums.Gender;
import app.impacto_manager.util.SystemWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import java.util.Arrays;


@Controller
@FxmlView("fxml/new/studens.fxml")
public class AlunoController{
    @FXML
    private ComboBox<String> comboBox_gender;
    @FXML
    private Button button_add;

    @FXML
    private Button button_close;

    @FXML
    public void initialize() {
        setComboBox_gender();
    }

    private void setComboBox_gender(){
        comboBox_gender.getItems().addAll(Arrays.stream(Gender.values()).map(Enum::toString).toList());
    }

    @FXML
    private void onButtonCloseClicked(ActionEvent event){
        SystemWindow.fecharJanela(event);
    }
}
