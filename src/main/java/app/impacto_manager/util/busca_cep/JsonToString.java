package app.impacto_manager.util.busca_cep;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonToString {
    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException, IOException, IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
