package conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexionAPI {
    private static final String API_KEY = "697a3666d54e6b8c1712cfc0";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public String obtenerTasasDeCambio(String monedaBase) throws Exception {
        URL url = new URL(BASE_URL + monedaBase);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conexion.getInputStream()));
        String linea;
        StringBuilder respuesta = new StringBuilder();

        while ((linea = reader.readLine()) != null) {
            respuesta.append(linea);
        }
        reader.close();

        return respuesta.toString();
    }


    public double extraerTasaDeCambio(String respuestaJSON, String monedaDestino) {

        String buscar = "\"" + monedaDestino + "\":";
        int inicio = respuestaJSON.indexOf(buscar) + buscar.length();
        int fin = respuestaJSON.indexOf(",", inicio);
        if (fin == -1) { // Si es el último elemento
            fin = respuestaJSON.indexOf("}", inicio);
        }
        return Double.parseDouble(respuestaJSON.substring(inicio, fin));
    }
}
