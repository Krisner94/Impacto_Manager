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
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static antlr.build.ANTLR.root;

public class SystemWindow {

    public static Stage openWindowInOtherStage(Node object,
                                               String title,
                                               boolean resizable,
                                               Modality modality) {

        return getStage((Parent) object, title, resizable, modality);
    }

    public static Stage openWindowInOtherStageForUpdate(Node node, String title, boolean resizable,
                                                        Modality modality,
                                                        Student student) {
        return getStage((Parent) node, title, resizable, modality);
    }

    private static Stage getStage(Parent node, String title, boolean resizable, Modality modality) {
        Scene scene = new Scene(node);
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

