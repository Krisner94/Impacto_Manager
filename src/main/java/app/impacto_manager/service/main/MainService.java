package app.impacto_manager.service.main;

import app.impacto_manager.controller.AlunoController;
import app.impacto_manager.enums.Gender;
import app.impacto_manager.model.Student;
import app.impacto_manager.service.aluno.AlunoService;
import app.impacto_manager.util.SystemWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final FxWeaver fxWeaver;
    public ObservableList<Student> studentList = FXCollections.observableArrayList();

    private static TableCell<Student, Button> call(TableColumn<Student, Button> param) {
        return new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    final Button btn = new Button("Excluir");
                    btn.setOnMouseClicked(e -> getTableView()
                            .getItems()
                            .remove((((TableCell<Student, String>) ((Button) e.getSource()).getParent()))
                                    .getTableRow().getItem()));
                    setGraphic(btn);
                }
            }
        };
    }

    public void initializeTableRows(TableColumn<Student, Button> column_edit,
                                    TableColumn<Student, Button> column_delete,
                                    TableView<Student> tableView_dataStudents) {
        column_edit.setCellFactory(param -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Student student = getTableRow().getItem();
                    final Button btn = new Button("Editar");
                    btn.setOnMouseClicked(event -> SystemWindow.openWindowInOtherStageForUpdate(
                            fxWeaver.load(AlunoController.class).getView().get(),
                            "Atualizar aluno", false,
                            Modality.WINDOW_MODAL, student));


                    setGraphic(btn);
                }
            }
        });

        column_delete.setCellFactory(MainService::call);

        studentList.addAll(
                new Student("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "122.416.126-26")
        );

        tableView_dataStudents.setItems(
                studentList
        );

    }


}
