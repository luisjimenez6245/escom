import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTe;
import javax.swing.JTextField;

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

public class executor extends Controller implements ActionListener {

    private static final long serialVersionUID = -6691512838218834379L;
    private JTextField field;
    private JButton btn;

    public executor() {
        super();
        setTitle("Triangulo");
        setVisible(true);
        setLayout(null);
        setSize(320, 320);
    }

    @Override
    protected loadView(){
        field = new JTextField("");
        btn = new JButton("Aceptar");
    }

    @Override
    protected loadContent(){

    }

    @Override
    protected loadActions(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String res = this.datTextField.getText() == null ? "" : this.datTextField.getText();
        if ((JButton) e.getSource() == calcButton) {
            try {
                int year = Integer.parseInt(res);
                year = 2019 - year;
                resultLabel.setText("Tienes " + Integer.toString(year) + " años.");
            } catch (Exception ex) {
                resultLabel.setText("Año no valido");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Digite el nivel de recursividad (Máximo 9): ");
        sierpEject.draw(new Scanner(System.in).next());
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