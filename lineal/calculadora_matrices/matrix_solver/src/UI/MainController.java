/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Utils.iViewController;
import controllers.MatrixController;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lusi
 */
public class MainController extends iViewController implements ActionListener {

    private JPanel panel;
    private int n = 3;

    private JComboBox combo;
    private List<JTextField> textFields;
    private JTextArea output;
    private boolean isValid;

    public MainController() {
        super();
        setVisible(true);
    }

    @Override
    protected void loadView() {
        setTitle("Edad");
        setLayout(null);
        setSize(840, 420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadContent() {
        JLabel title = new JLabel("Selecciona N:");
        String options[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        combo = new JComboBox(options);
        JButton buttonCalc = new JButton("Calcular");
        JButton buttonCalcInver = new JButton("Inversa");
        output = new JTextArea("");
        JScrollPane scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        n = 3;

        title.setBounds(20, 20, 100, 30);
        combo.setBounds(120, 20, 80, 30);
        buttonCalc.setBounds(20, 60, 80, 30);
        buttonCalcInver.setBounds(100, 60, 80, 30);

        output.setSize(520, 420);
        scroll.setBounds(420, 0, 520, 420);

        buttonCalc.addActionListener(this);
        buttonCalcInver.addActionListener(this);

        add(scroll);
        add(title);
        add(combo);
        add(buttonCalc);
        add(buttonCalcInver);

    }

    @Override
    protected void loadActions() {
        fillPanel();
        combo.addActionListener((ActionEvent e) -> {
            n = Integer.parseInt(combo.getSelectedItem().toString());
            remove(panel);
            fillPanel();
            this.invalidate();
            this.validate();
            this.repaint();
        });
        output.setEditable(false);
        output.setBackground(Color.WHITE);
    }

    private double[][] getMatrix() {
        double[][] res = new double[n][n];
        int iIterable = 0, jIterable = 0;
        for (JTextField f : textFields) {
            res[iIterable][jIterable] = Double.parseDouble(f.getText());
            ++jIterable;
            if (jIterable == n) {
                jIterable = 0;
                ++iIterable;
            }
        }
        return res;
    }

    private boolean isValidMatrix() {
        return textFields.stream().map((b) -> b.getText() == null ? "" : b.getText()).noneMatch((aux) -> (!isInteger(aux)));
    }

    private boolean isInteger(String text) {
        try {
            double t = Double.parseDouble(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private void fillPanel() {
        panel = new JPanel();
        panel.setBounds(20, 90, (n * 55), (n * 35));
        GridLayout layout = new GridLayout(n, n);
        combo.setSelectedIndex(n - 2);
        textFields = new ArrayList<>();
        panel.setLayout(layout);
        for (int i = 0; i < Math.pow(n, 2); ++i) {
            JTextField text = new JTextField("0");
            this.panel.add(text);
            text.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    changeTexFieldContent(text);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    changeTexFieldContent(text);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    changeTexFieldContent(text);
                }
            });
            textFields.add(text);
        }
        add(panel);
        this.isValid = true;
    }

    private void changeTexFieldContent(JTextField b) {
        String aux = b.getText() == null ? "" : b.getText();
        if (!(isInteger(aux))) {
            b.setForeground(Color.RED);
            this.isValid = false;
        } else {
            b.setForeground(Color.BLACK);
            this.isValid = true;
        }
    }

    private void calAction() {
        MatrixController control = new MatrixController();
        String res = control.textMatrix(getMatrix());
        output.setText(output.getText() + "\n" + res);
    }

    private void inverseAction() {
        MatrixController control = new MatrixController();
        String res;
        double[][] matrix = getMatrix();
        try {
            matrix = control.getInverseMatrix(matrix);
            res = "Inversa de la matriz:\n\n" + control.textMatrix(matrix);
        } catch (Exception ex) {
            res = ex.getMessage();
            res += "\n \n" + control.textMatrix(matrix);

        }
        output.setText(output.getText() + "\n" + res);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isValid && isValidMatrix()) {
            String b = ((JButton) e.getSource()).getText();
            b = b.toLowerCase();
            if (b.equals("calcular")) {
                calAction();
            } else {
                inverseAction();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Revisa la matriz");
        }
    }

}
