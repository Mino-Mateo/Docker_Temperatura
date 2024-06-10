import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Crear una instancia del objeto remoto
            ConversorRemotoImpl conversor = new ConversorRemotoImpl();

            // Registrar el objeto remoto en el registro RMI
            LocateRegistry.createRegistry(5000); // puerto por defecto de RMI
            Naming.rebind("rmi://localhost:5000/ConversorRemoto", conversor);

            System.out.println("Servidor RMI listo y esperando solicitudes...");
        } catch (MalformedURLException | RemoteException e) {
            System.err.println("Error en el servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
