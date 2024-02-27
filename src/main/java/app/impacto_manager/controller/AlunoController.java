package app.impacto_manager.controller;

import app.impacto_manager.enums.Gender;
import app.impacto_manager.model.Student;
import app.impacto_manager.service.aluno.AlunoService;
import app.impacto_manager.util.SystemWindow;
import app.impacto_manager.util.busca_cep.BuscaCep;
import app.impacto_manager.util.busca_cep.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
@FxmlView("/fxml/new/studens.fxml")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService service;
    private SystemWindow window;

    //TODO: desfazer essa bagaça quando implementar o banco de dados
    @FXML
    public ComboBox<String> comboBox_gender;
    @FXML
    public TextField textField_studentName;
    @FXML
    private DatePicker datePicker_born;
    @FXML
    public TextField textField_cpf;
    @FXML
    public TextField textField_cep;
    @FXML
    private TextField textField_cidade;
    @FXML
    private TextField textField_rua;
    @FXML
    private TextField textField_bairro;
    @FXML
    public TextField textField_numeroCasa;
    @FXML
    public TextField textField_telefone;


    @FXML
    private void initialize() {
        setComboBox_gender();

    }

    private void setComboBox_gender() {
        comboBox_gender.getItems().addAll(Arrays.stream(Gender.values()).map(Enum::toString).toList());
    }

    @FXML
    private void onButtonCloseClicked(ActionEvent event) {
        window.fecharJanela(event);
    }

    @FXML
    private void searchCepOnClick() {
        String cep = textField_cep.getText();
        System.out.println(cep);
        Endereco endereco = BuscaCep.buscaCep(cep);

        textField_bairro.setText(endereco.getBairro());
        textField_cidade.setText(endereco.getLocalidade());
        textField_rua.setText(endereco.getLogradouro());
    }

    @FXML
    private void print(ActionEvent event) {
        service.addNewStudent();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(textField_studentName.getText()).append(" ");
        sb.append(datePicker_born.getValue()).append(" ");
        sb.append(comboBox_gender.getValue()).append(" ");
        sb.append(textField_cpf.getText()).append(" ");
        sb.append(textField_cep.getText()).append(" ");
        sb.append(textField_cidade.getText()).append(" ");
        sb.append(textField_rua.getText()).append(" ");
        sb.append(textField_bairro.getText()).append(" ");
        sb.append(textField_numeroCasa.getText()).append(" ");
        sb.append(textField_telefone.getText()).append(" ");

        System.out.println(sb);

        window.fecharJanela(event);
    }

    public void setStudent(Student student) {
        textField_studentName.setText(student.getName());
        textField_cpf.setText(student.getCPF());
        comboBox_gender.setValue(student.getGender().toString());
    }
}