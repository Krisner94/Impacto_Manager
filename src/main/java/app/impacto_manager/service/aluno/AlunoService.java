package app.impacto_manager.service.aluno;

import app.impacto_manager.model.Student;
import app.impacto_manager.util.SystemWindow;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    public void addStudent(){
        SystemWindow.openWindowInOtherStage("/fxml/new/studens.fxml", "Novo Aluno", false, Modality.APPLICATION_MODAL);
    }

    public void initializeTableRows(TableColumn<Student, Button> column_edit, TableColumn<Student, Button> column_delete) {
        column_edit.setCellFactory(param -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Student student = getTableRow().getItem();
                    final Button btn = new Button("Editar");
                    btn.setOnMouseClicked(event -> {

                        String uri = "/fxml/new/studens.fxml";
                        SystemWindow.openWindowInOtherStageForUpdate(uri, "Atualizar aluno", false,
                                Modality.WINDOW_MODAL, student);

                    });
                    setGraphic(btn);
                }
            }
        });

        column_delete.setCellFactory(param -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    final Button btn = new Button("Excluir");
                    btn.setOnMouseClicked(e -> {
                        getTableView().getItems().remove((((TableCell<Student, String>) ((Button) e.getSource()).getParent())).getTableRow().getItem());
                    });
                    setGraphic(btn);
                }
            }
        });
    }
}
