import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class Client extends Controller implements ActionListener {

    private JTextField pregunta;
	private JLabel respuesta;
    private JButton enviar;
    
    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        super();
        setTitle("ChatBot");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadView() {
        this.setSize(500, 500);
        pregunta = new JTextField();
        respuesta = new JLabel();
        enviar = new JButton("Enviar");
        this.setLayout(new GridLayout(3, 1));

    }

    @Override
    protected void loadContent() {
        this.add(pregunta);
        this.add(enviar);
        this.add(respuesta);
    }

    @Override
    protected void loadActions() {
        enviar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String preg = (String) pregunta.getText();
        String resp;
        try {
            Registry registry = LocateRegistry.getRegistry();
            iRemote stub = (iRemote) registry.lookup("iRemote");
            resp = stub.printMsg(preg);
            if (resp.equals(""))
                respuesta.setText(":c");
            else {
                respuesta.setText(resp);
            }

        } catch (Exception ex) {
            System.out.println("Nope: " +  ex.getLocalizedMessage());
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
        this.setVisible(true);
    }

    protected abstract void loadView();

    protected abstract void loadContent();

    protected abstract void loadActions();

}
interface iRemote extends Remote {
    String printMsg(String pregunta) throws RemoteException;
}