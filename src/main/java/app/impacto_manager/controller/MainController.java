package app.impacto_manager.controller;

import app.impacto_manager.enums.Gender;
import app.impacto_manager.model.Students;
import app.impacto_manager.util.SystemWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import static app.impacto_manager.util.SystemWindow.openWindowInSameStage;

@Component
@Controller
@FxmlView("fxml/main.fxml")
public class MainController {
    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Students> tableView_dataStudents;
    @FXML
    private TableColumn<Students, Long> colum_id;
    @FXML
    private TableColumn<Students, String> column_name;
    @FXML
    private TableColumn<Students, String> column_gender;
    @FXML
    private TableColumn<Students, String> column_phone;
    @FXML
    private TableColumn<Students, String> column_cpf;
    @FXML
    private TableColumn<Students, Button> column_edit;
    @FXML
    private TableColumn<Students, Button> column_delete;

    AlunoController alunoController = new AlunoController();
    Students student;

    @FXML
    private void initialize() {
        colum_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_cpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));

        tabelaAlunosMock();
    }

//    private void configTableView_dataStudents(){
//        tableView_dataStudents.getItems().set(
//
//        )
//    }

    private void tabelaAlunosMock() {
        ObservableList<Students> studentsList = FXCollections.observableArrayList();
        studentsList.setAll(
                new Students("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "12241612626"),
                new Students("Rhama Krisner Davidson", Gender.MASCULINO, "(31)99902-0564", "12241612626"),
                new Students("Rhama Krisner", Gender.MASCULINO, "(31)99902-0564", "12241612626")
        );

        tableView_dataStudents.getItems().addAll(
                studentsList
        );
        editButton();
        buttonDelete();
    }


    @FXML
    private void openStudentOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/studens.fxml", "Novo Aluno", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openTeacherOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/teacher.fxml", "Novo professor", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openClassroomOnMouseClick() {
        SystemWindow.openWindowInOtherStage("/fxml/new/classroom.fxml", "Nova Turma", false, Modality.APPLICATION_MODAL);
    }

    @FXML
    private void openSeeStudentsOnMouseClick() {
        openWindowAndClearPane();
    }

    @FXML
    private void openSeeTeacherOnMouseClick() {
        String uri = "/fxml/see/teacher.fxml";
        String title = "Professores";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    @FXML
    private void openSeeClassroomOnMouseClick() {
        String uri = "/fxml/see/classroom.fxml";
        String title = "Turmas";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    @FXML
    private void openConfigOnMouseClick() {
        String uri = "/fxml/configurations/configurations.fxml";
        String title = "Turmas";
        SystemWindow.openWindowInOtherStage(uri, title, false, Modality.WINDOW_MODAL);
    }

    private void openWindowAndClearPane() {
        Pane pane = openWindowInSameStage("/fxml/main.fxml");
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }
    private void editButton(){
        column_edit.setCellFactory(param -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    final Button btn = new Button("Editar");
                    btn.setOnMouseClicked(event -> {
                        student = getTableView().getItems().get(getIndex());

                        String uri = "/fxml/new/studens.fxml";
                        SystemWindow.openWindowInOtherStageForUpdate(uri, "Atualizar aluno", false,
                                Modality.WINDOW_MODAL, student);

                    });
                    setGraphic(btn);
                }
            }
        });
    }

    private void buttonDelete() {
        column_delete.setCellFactory(param -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    final Button btn = new Button("Excluir");
                    btn.setOnMouseClicked(e -> {
                        getTableView().getItems().remove((((TableCell<Students, String>) ((Button) e.getSource()).getParent())).getTableRow().getItem());
                    });
                    setGraphic(btn);
                }
            }
        });
    }
}
