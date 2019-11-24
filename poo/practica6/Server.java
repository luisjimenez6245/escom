import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;

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
            acceptClient(server.accept());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida." + e.getMessage());
        }
    }

    public void acceptClient(Socket socket) throws IOException {
        System.out.println("Nuevo Cliente");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String imageName = getInputString(entrada);
        System.out.println(imageName);
        ByteArrayOutputStream byteArrayOutputStream = getImageBytes(getImage("./imagenes/" + imageName));
        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        socket.close();
    }

    private ByteArrayOutputStream getImageBytes(BufferedImage image) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    public String getInputString(BufferedReader stdIn) throws IOException {
        String res = "";
        String userInput = "";
        while ((userInput = stdIn.readLine()) != null) {
            res += userInput;
        }
        return res;
    }

    public BufferedImage getImage(String name) throws IOException{
        return ImageIO.read(new File(name));
    }
}