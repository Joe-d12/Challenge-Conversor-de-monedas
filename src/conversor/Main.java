package conversor;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();

        while (true) {
            System.out.println("\n'******* Conversor de Monedas ******");
            System.out.println("1. Realizar conversión");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 2) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            if (opcion == 1) {
                try {
                    List<Moneda> monedas = conversor.getMonedasDisponibles();
                    conversor.mostrarMonedasDisponibles();

                    System.out.print("\nSeleccione el número de la moneda de origen: ");
                    int indiceOrigen = scanner.nextInt() - 1;

                    System.out.print("Seleccione el número de la moneda que desea cambiar: ");
                    int indiceDestino = scanner.nextInt() - 1;

                    System.out.print("Ingrese la cantidad a convertir: ");
                    double cantidad = scanner.nextDouble();

                    if (indiceOrigen >= 0 && indiceOrigen < monedas.size() &&
                            indiceDestino >= 0 && indiceDestino < monedas.size()) {

                        String monedaOrigen = monedas.get(indiceOrigen).getCodigo();
                        String monedaDestino = monedas.get(indiceDestino).getCodigo();

                        double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);

                        System.out.println("\n\nEl cambio es equivalente a");
                        System.out.printf("\n%.2f %s = %.2f %s\n",
                                cantidad, monedaOrigen, resultado, monedaDestino);
                    } else {
                        System.out.println("Selección de moneda inválida");
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }
}