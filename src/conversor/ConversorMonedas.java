package conversor;

import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {
    private List<Moneda> monedasDisponibles;
    private ConexionAPI conexionAPI;

    public ConversorMonedas() {
        this.conexionAPI = new ConexionAPI();
        this.monedasDisponibles = inicializarMonedas();
    }

    private List<Moneda> inicializarMonedas() {
        List<Moneda> monedas = new ArrayList<>();

        monedas.add(new Moneda("USD", "Dólar Estadounidense"));
        monedas.add(new Moneda("EUR", "Euro"));
        monedas.add(new Moneda("GBP", "Libra Esterlina"));
        monedas.add(new Moneda("JPY", "Yen Japonés"));
        monedas.add(new Moneda("ARS", "Peso Argentino"));
        monedas.add(new Moneda("BOB", "Boliviano - Bolivia"));
        monedas.add(new Moneda("BRL", "Real Brasileño"));
        monedas.add(new Moneda("CLP", "Peso Chileno"));
        monedas.add(new Moneda("COP", "Peso Colombiano"));
        monedas.add(new Moneda("CRC", "Colón Costarricense"));
        monedas.add(new Moneda("DOP", "Peso Dominicano"));
        monedas.add(new Moneda("GTQ", "Quetzal Guatemalteco"));
        monedas.add(new Moneda("HNL", "Lempira Hondureño"));
        monedas.add(new Moneda("MXN", "Peso Mexicano"));
        monedas.add(new Moneda("NIO", "Córdoba Nicaragüense"));
        monedas.add(new Moneda("PAB", "Balboa Panameño"));
        monedas.add(new Moneda("PEN", "Sol Peruano"));
        monedas.add(new Moneda("PYG", "Guaraní Paraguayo"));
        monedas.add(new Moneda("UYU", "Peso Uruguayo"));
        monedas.add(new Moneda("VES", "Bolívar Digital Venezolano"));
        return monedas;
    }

    public List<Moneda> getMonedasDisponibles() {
        return monedasDisponibles;
    }

    public void mostrarMonedasDisponibles() {
        System.out.println("\nMonedas disponibles:");
        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + monedasDisponibles.get(i));
        }
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            String respuesta = conexionAPI.obtenerTasasDeCambio(monedaOrigen);
            double tasa = conexionAPI.extraerTasaDeCambio(respuesta, monedaDestino);
            return cantidad * tasa;
        } catch (Exception e) {
            System.out.println("Error al convertir: " + e.getMessage());
            return 0;
        }
    }

}
