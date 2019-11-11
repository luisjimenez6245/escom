
import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputAdapter;


public class executor {

    public static void main(String[] args) {
        new Panel();
    }

}

class Panel extends Controller {

    private static final String FILE = "/Users/luis/Documents/GitHub/escom/poo/practica2/remainder.txt";
    private static final long serialVersionUID = 1L;
    private JComboBox combo;
    private JPanel panelContainer;
    private String options[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String imgs[];
    private float time = 1;
    private int counter = 0;


    public Panel() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }

    @Override
    protected void loadView() {
        setTitle("Reloj");
        setVisible(true);
        setLayout(null);
        setSize(320, 320);
        combo = new JComboBox(options);
        panelContainer = new JPanel();
        combo.setBounds(20, 0, 80, 30);
        panelContainer.setBounds(20, 40, 300, 250);
        add(combo);
        add(panelContainer);
    }

    @Override
    protected void loadContent() {
        imgs = new BufferedImage[4];
        imgs[0] = ("filename");
        imgs[1] = ("filename");
        imgs[2] = ("filename");
        imgs[3] = ("filename");
    }

    @Override
    protected void loadActions() {
        combo.addActionListener((ActionEvent e) -> {
            n = Integer.parseInt(combo.getSelectedItem().toString());
            this.invalidate();
            this.validate();
            this.repaint();
        });
      
    }

    private void changeContent(){
        Image background = Toolkit.getDefaultToolkit().createImage(imgs[counter]);
        this.drawImage(background, 0, 0, null);
    }

    private void manageClock() {
        new Thread() {
            public void run() {
                while (true) {
                    changeContent();
                    if (counter >= imgs.length)
                    {
                        counter = 0;
                    }
                    try {
                        sleep(time  * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++counter;
                }
            }
        }.start();
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

class Files {

    public static String getFile(String path) {
        try {
            String res = "";
            String helper = "";
            try (BufferedReader stdInput = new BufferedReader(new FileReader(path))) {
                while ((helper = stdInput.readLine()) != null) {
                    res += helper + "\n";
                }
            }
            return res;
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    public static BufferedImage getImage(String filename) {
        try {
            InputStream in = getResourceAsStream(filename);
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        return null;
    }

}