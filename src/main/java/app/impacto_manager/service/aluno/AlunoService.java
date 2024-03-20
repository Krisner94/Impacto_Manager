package app.impacto_manager.service.aluno;

import app.impacto_manager.JavaFXMain;
import app.impacto_manager.controller.AlunoController;
import app.impacto_manager.enums.Gender;
import app.impacto_manager.model.Student;
import app.impacto_manager.service.main.MainService;
import app.impacto_manager.util.SystemWindow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final MainService mainService;
    private final FxWeaver fxWeaver;
    private Student student;

    public void addStudentStage() {
        SystemWindow.openWindowInOtherStage(fxWeaver.load(AlunoController.class).getView().get(),
                "Novo Aluno", false, Modality.APPLICATION_MODAL);
    }

    public void updateStudentData(Student student){
        SystemWindow.openWindowInOtherStageForUpdate(fxWeaver.load(AlunoController.class).getView().get(),
                "Atualizar Aluno", false, Modality.APPLICATION_MODAL, student);

        getController().textField_studentName.setText(student.getName());
        getController().comboBox_gender.setValue(student.getGender().name());
        getController().textField_telefone.setText(student.getGender().toString());
        getController().textField_cpf.setText(student.getCPF());
    }

    public void addNewStudent() {
        mainService.studentList.add(new Student(getController().textField_studentName.getText(),
                Gender.valueOf(getController().comboBox_gender.getValue().toUpperCase()),
                getController().textField_telefone.getText(),
                getController().textField_cpf.getText()));
    }

    private AlunoController getController() {
        return JavaFXMain.context.getBean(AlunoController.class);
    }
}
