package app.impacto_manager.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class NewWindow {
    public static Node abrirJanela(String fxmlUri){
        FXMLLoader fxmlLoader = new FXMLLoader(NewWindow.class.getResource(fxmlUri));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return root;
    }
}
