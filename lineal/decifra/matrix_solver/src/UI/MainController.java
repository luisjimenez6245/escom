/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Utils.iViewController;
import controllers.Controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author lusi
 */
public class MainController extends iViewController implements ActionListener {

    private JTextArea input;
    private JTextArea output;
    private Controller control;

    public MainController() {
        super();
        setVisible(true);
        try {
            control = new Controller();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void loadView() {
        setTitle("Mensajes");
        setLayout(null);
        setSize(740, 420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadContent() {

        JLabel label = new JLabel("Input:");
        JButton buttonCalc = new JButton("Encripta");
        JButton buttonCalcInver = new JButton("Desencripta");
        output = new JTextArea("");
        input = new JTextArea("");

        n = 3;

        label.setBounds(40, 10, 80, 30);
        buttonCalc.setBounds(40, 350, 100, 30);
        buttonCalcInver.setBounds(150, 350, 100, 30);

        input.setBounds(40, 40, 320, 300);

        input.setLineWrap(true);
        input.setWrapStyleWord(true);

        output.setBounds(420, 0, 320, 420);
      output.setLineWrap(true);
        output.setWrapStyleWord(true);
        buttonCalc.addActionListener(this);
        buttonCalcInver.addActionListener(this);

        add(label);
        add(input);
        add(output);
        add(buttonCalc);
        add(buttonCalcInver);

    }

    @Override
    protected void loadActions() {
        output.setEditable(false);
        output.setBackground(Color.WHITE);
    }

    private void encrypt() {
        output.setText(control.encrypt(input.getText()));
    }

    private void decrypt() {
        output.setText(control.decrypt(input.getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Encripta")) {
            encrypt();
        } else {
            if (button.getText().equals("Desencripta")) {
                decrypt();
            }
        }
        output.setLineWrap(true);
        output.setWrapStyleWord(true);

    }

}
