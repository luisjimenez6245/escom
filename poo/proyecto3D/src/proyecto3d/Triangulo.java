/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */
public class Triangulo {

    public int number = 0;

    public Triangulo() {
        f a = new f();
        new Thread(){
            public void run() {
                while (number == 0) {
                    a.method();
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private class f extends Controller implements ActionListener {

        private static final long serialVersionUID = -6691512838218834379L;
        private JTextField field;
        private JButton btn;
        public boolean r;

        public f() {
            super();
        }

        @Override
        protected void loadView() {
            setLayout(null);
            setTitle("Triangulo");
            setVisible(true);
            setSize(320, 320);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            field = new JTextField("");
            btn = new JButton("Aceptar");
            field.setBounds(100, 50, 90, 30);
            btn.setBounds(100, 100, 90, 30);
            this.add(field);
            this.add(btn);

        }
        
        public void method(){}

        @Override
        protected void loadContent() {

        }

        @Override
        protected void loadActions() {
            btn.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String res = this.field.getText() == null ? "" : this.field.getText();
            try {
                this.setVisible(false);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            } catch (Throwable ex) {
                Logger.getLogger(Triangulo.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            number = (Integer.parseInt(res));
            r = false;
        }
    }

}
