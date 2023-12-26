package app.impacto_manager.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NovaJanela {
    public static void abrirJanela(Class<?> classe,  String fxmlUri, String titulo) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(classe.getResource(fxmlUri));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }
}
