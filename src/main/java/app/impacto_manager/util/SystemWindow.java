package app.impacto_manager.util;

import app.impacto_manager.controller.AlunoController;
import app.impacto_manager.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SystemWindow {

    public static Stage openWindowInOtherStage(String fxmlUri, String title, boolean resizable, Modality modality) {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemWindow.class.getResource(fxmlUri));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.initModality(modality);
        stage.initStyle(StageStyle.UNIFIED);
        stage.show();
        return stage;
    }

    public static Stage openWindowInOtherStageForUpdate(String fxmlUri, String title, boolean resizable,
                                                      Modality modality,
                                                Student student) {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemWindow.class.getResource(fxmlUri));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        AlunoController controller = fxmlLoader.getController();
        controller.setStudent(student);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.initModality(modality);
        stage.initStyle(StageStyle.UNIFIED);
        stage.show();
        return stage;
    }

    public static Pane openWindowInSameStage(String fxmlUri) {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemWindow.class.getResource(fxmlUri));
        Pane pane;
        try {
            pane = fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return pane;
    }

    public static void fecharJanela(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}

