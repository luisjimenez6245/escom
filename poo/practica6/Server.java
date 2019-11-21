import java.io.*;
import java.net.*;

public class Server {
    private static int PUERTO = 2017;

    public static void main(String args[]) {

        BufferedReader entrada;
        DataOutputStream salida;
        Socket socket;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PUERTO);

            System.out.println("Esperando una conexión...");

            socket = serverSocket.accept();

            System.out.println("Un cliente se ha conectado...");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            salida = new DataOutputStream(socket.getOutputStream());

            System.out.println("Confirmando conexion al cliente....");

            String mensajeRecibido = entrada.readLine();


            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error de entrada/salida." + e.getMessage());
        }

    }
}