package app.impacto_manager.util.busca_cep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class BuscaCep {

    public static Endereco buscaCep(String cep) {
        String webService = "https://viacep.com.br/ws/";
        String urlChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlChamada);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int successCode = 200;
            if (connection.getResponseCode() != successCode) {
                throw new RuntimeException("HTTP ERROR CODE: " + connection.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonEmString = JsonToString.converteJsonEmString(resposta);
            Gson gson = new Gson();
            return gson.fromJson(jsonEmString, Endereco.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
