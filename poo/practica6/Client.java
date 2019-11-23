import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.File;
import java.awt.image.*;

import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import java.net.Socket;

public class Client {

    private static String HOST = "localhost";
    private static int PORT = 2017;

    public static void main(String args[]) throws IOException {
        new Client("image.png");
    }

    public Client(String name) throws IOException{
        createSocket(name);
    }
    public void createSocket(String name) throws IOException{
        Socket socket =  new Socket(HOST, PORT);
        InputStream inputStream = socket.getInputStream();
        byte[] sizeAr = new byte[4];
        DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream()); 
        mensaje.writeUTF(name);
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
        ImageIO.write(image, "jpg", new File("C:\\Users\\Jakub\\Pictures\\test2.jpg"));
        socket.close();
    }
}