import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.File;
import java.awt.image.*;

import java.io.PrintWriter;;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        new Executor();
    }
}

class Executor extends Controller implements ActionListener, Runnable {

    private JLabel panel;
    private JButton iniciar, siguiente, anterior;
    private int contador = 0;
    private String[] imagenes = { "a.jpg", "e.jpg" "i.jpg" };
    private final ImageClient client;
    private Thread cambio;

    public Executor() {
        super();
        client = new ImageClient();
        setSize(380, 480);
        setTitle("Marco Digital");
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadView() {
        cambio = new Thread(this);
        panel = new JLabel();
        iniciar = new JButton("Pausar");
        siguiente = new JButton("Siguiente");
        anterior = new JButton("Anterior");
        panel.setBounds(15, 15, 350, 400);
        iniciar.setBounds(145, 415, 90, 35);
        siguiente.setBounds(300, 415, 90, 35);
        anterior.setBounds(15, 415, 90, 35);
        add(panel);
        add(iniciar);
        add(siguiente);
        add(anterior);
    }

    @Override
    protected void loadContent() {
        panel.setLayout(new BorderLayout());
    }

    @Override
    protected void loadActions() {
        iniciar.addActionListener(this);
        siguiente.addActionListener(this);
        anterior.addActionListener(this);
        cambio.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == iniciar) {
            if (iniciar.getText().equals("Pausar")) {
                iniciar.setText("Iniciar");
                cambio.stop();
                cambio.destroy();
                cambio = null;
            } else {
                iniciar.setText("Pausar");
                cambio = new Thread(this);
                cambio.start();
            }
        } else {
            if (btn == anterior) {
                loadImage(-1);
                --contador;
            } else {
                loadImage(1);
                ++contador;
            
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                loadImage(1);
                ++contador;
                cambio.sleep(3000);
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }

    private void loadImage(int action) {
        getNumber(action == 1);
        try {
            String helper = imagenes[contador];
            panel.setIcon(new ImageIcon(client.getImage(imagenes[contador])));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void getNumber(boolean to) {
        if (to) {
            if (contador == (imagenes.length)) {
                contador = 0;
            }
        } else {
            if (contador == 0) {
                contador = imagenes.length - 1;
            }
        }
    }
}

class ImageClient {

    private static String HOST = "localhost";
    private static int PORT = 2017;

    public ImageClient() {
    }

    public byte[] getImage(String name) throws IOException {
        Socket socket = new Socket(HOST, PORT);
        PrintWriter mensaje = new PrintWriter(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        mensaje.println(name);
        mensaje.flush();
        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
        System.out.println(size);
        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);
        ByteArrayInputStream b = new ByteArrayInputStream(imageAr);
        socket.close();
        return imageAr;
    }

}

abstract class Controller extends JFrame {

    private static final long serialVersionUID = -6691512838218834379L;

    public Controller() {
        loadView();
        loadContent();
        loadActions();
        this.invalidate();
        this.validate();
        this.repaint();
    }

    protected abstract void loadView();

    protected abstract void loadContent();

    protected abstract void loadActions();

}