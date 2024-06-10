import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            // Localizar el objeto remoto
            ConversorRemoto conversor = (ConversorRemoto) Naming.lookup("rmi://localhost:5000/ConversorRemoto");

            try ( // Interactuar con el usuario
                    Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Convertir de Celsius a Fahrenheit");
                    System.out.println("2. Convertir de Fahrenheit a Celsius");
                    System.out.println("3. Salir");

                    int opcion = scanner.nextInt();

                    if (opcion == 3) {
                        System.out.println("Saliendo...");
                        break;
                    }

                    System.out.print("Ingrese la temperatura: ");
                    double temperatura = scanner.nextDouble();
                    double resultado;

                    switch (opcion) {
                        case 1 -> {
                            resultado = conversor.celsiusAFahrenheit(temperatura);
                            System.out.println(temperatura + " Celsius son " + resultado + " Fahrenheit.");
                            System.out.println("*********************************************************");
                        }
                        case 2 -> {
                            resultado = conversor.fahrenheitACelsius(temperatura);
                            System.out.println(temperatura + " Fahrenheit son " + resultado + " Celsius.");
                            System.out.println("*********************************************************");
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                }
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
