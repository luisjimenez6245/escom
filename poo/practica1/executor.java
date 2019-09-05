import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class executor {

    public static void main(String[] args) {
        new Panel();
    }

}

class Panel extends JFrame implements ActionListener {

    private static final long serialVersionUID = -6691512838218834379L;
    private JTextField datTextField;
    private JButton calcButton;
    private JLabel resultLabel;

    public Panel() {

        super();
        setTitle("Edad");
        setVisible(true);
        setLayout(null);
        setSize(320, 320);

        datTextField = new JTextField();
        datTextField.setBounds(10, 10, 300, 50);
        datTextField.setVisible(true);
        datTextField.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(datTextField);

        calcButton = new JButton();
        calcButton.setText("Calcular");
        calcButton.setFont(new Font("Arial", Font.PLAIN, 25));
        calcButton.setBounds(10, 80, 300, 50);
        calcButton.setVisible(true);

        calcButton.addActionListener(this);
        this.add(calcButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(10, 135, 300, 50);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        resultLabel.setVisible(true);
        this.add(resultLabel);
        this.repaint();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

}