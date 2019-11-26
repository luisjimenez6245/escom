import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;

import java.util.Scanner;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import java.net.ServerSocket;
import java.net.Socket;

import java.awt.image.*;

public class Server {

    private static int PORT = 2017;
    private ServerSocket server;

    public static void main(String args[]) {
        new Server();
    }

    public Server() {
        try {
            server = new ServerSocket(PORT);
            while (true) {
                acceptClient(server.accept());
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida. " + e.getMessage());
        }
    }

    public void acceptClient(Socket socket) throws IOException {
        System.out.println("Nuevo Cliente");
        Scanner entrada = new Scanner(socket.getInputStream());
        OutputStream outputStream = socket.getOutputStream();
        String res = "";
        while (entrada.hasNextLine()) {
            res = entrada.nextLine();
            ByteArrayOutputStream byteArrayOutputStream = getImageBytes(getImage("imagenes/" + res));
            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            System.out.println(byteArrayOutputStream.size());
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
        }
        socket.close();
    }

    private ByteArrayOutputStream getImageBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        System.out.println(byteArrayOutputStream.size());
        return byteArrayOutputStream;
    }

    public BufferedImage getImage(String name) throws IOException {
        File f = new File(name);
        return ImageIO.read(f);
    }
}