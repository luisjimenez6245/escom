import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class executor {

    public static void main(String[] args) {
        new Panel();
    }

}

class Panel extends Controller implements ActionListener, Runnable {

    private JPanel panel;
    private JButton botones[], iniciar;
    private JLabel marcador;
    private ImageIcon imagenes[];
    private int topos;
    private Thread cambio;

    public Panel() {
        super();
        setSize(550, 450);
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadView() {
        topos = 0;
        cambio = new Thread(this);
        cambio.start();
        this.setTitle("Pegale al Topo");
        setLayout(new GridLayout(5, 4));
        botones = new JButton[20];
        imagenes = new ImageIcon[2];
        imagenes[0] = new ImageIcon("2.jpg");
        imagenes[1] = new ImageIcon("1.jpg");
        iniciar = new JButton("Reiniciar");
        marcador = new JLabel("P:0");
        iniciar.setFont(new Font("Arial", Font.PLAIN, 25));
        marcador.setFont(new Font("Arial", Font.PLAIN, 25));

    }

    @Override
    protected void loadContent() {
        crear();
        this.add(iniciar);
        this.add(marcador);
        this.setVisible(true);

    }

    @Override
    protected void loadActions() {
        iniciar.addActionListener(this);
        for (int i = 0; i < 20; i++) {
            botones[i].addActionListener(this);
        }

    }

    public void crear() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int x1 = Math.abs(r.nextInt() % 5);
            if (x1 == 0)
                botones[i] = new JButton((imagenes[0]));
            else
                botones[i] = new JButton((imagenes[1]));
            botones[i].setBackground(java.awt.Color.white);
            add(botones[i]);
        }

    }

    public void reiniciar() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            botones[i].setEnabled(true);
            int x1 = Math.abs(r.nextInt() % 5);
            if (x1 == 0)
                botones[i].setIcon(imagenes[0]);
            else
                botones[i].setIcon(imagenes[1]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getIcon() == imagenes[0]) {
            btn.setIcon(imagenes[1]);
            btn.setEnabled(false);
            topos++;
        } else if (btn == iniciar) {
            topos = 0;
            reiniciar();
        }
        marcador.setText("P:" + topos);
    }

    public void run() {
        int t;
        Random r = new Random();

        t = Math.abs(r.nextInt() % 5) + 1;
        while (true) {
            try {
                cambio.sleep(t * 500);
                reiniciar();
                cambio.start();
            } catch (Exception e) {
                e.getMessage();
            }

        }
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