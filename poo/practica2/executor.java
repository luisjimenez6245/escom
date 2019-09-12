
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;

public class executor {

    public static void main(String[] args) {
        new Panel();
    }

}

class Remainder {
    public enum Repetable {
        DAILY, WEEKLY, MONTHLY, YEARLY,
    }

    public Remainder() {
    }

    public Remainder[] build(String json) {
        List<Remainder> res = new ArrayList<>();
        String list[] = json.split("$$%");
        for (String l : list) {
            Remainder r = new Remainder().buildSelf(l);
            if (r != null)
                res.add(r);
        }
        return res.toArray(new Remainder[res.size()]);
    }

    public Remainder buildSelf(String json) {
        String helper[] = json.split("&&%");
        try {
            this.hour = helper[1];
            this.day = helper[2];
            this.shouldRepeat = Boolean.parseBoolean(helper[3]);
            this.isRepatable = Repetable.valueOf(helper[0]);
            this.content = helper[4];
            return this;

        } catch (Exception ex) {

        }
        return null;
    }

    public boolean shouldRepeat;
    public String hour;
    public String day;
    public Repetable isRepatable;
    public String content;
}

class Panel extends Controller implements ActionListener {

    private static final String FILE = "/Users/lusi/Documents/GitHub/escom/poo/practica2/remainder.txt";
    private static final long serialVersionUID = 1L;
    private JLabel clockLabel;
    private List<JLabel> remiandersLabels;
    private Remainder[] remainders;
    private JPanel panelRemainder;
    private DateFormat dateFormat;

    public Panel() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        manageClock();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    protected void loadView() {
        JPanel panelClock = new JPanel();
        dateFormat = new SimpleDateFormat("hh:mm:ss a");
        setTitle("Reloj");
        setVisible(true);
        setLayout(null);
        setSize(320, 320);
        panelClock = new JPanel();
        panelRemainder = new JPanel();
        clockLabel = new JLabel("aaa");
        JScrollPane scroll = new JScrollPane(panelRemainder, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelClock.setBounds(0, 20, 320, 100);
        scroll.setBounds(0, 100, 320, 220);
        panelRemainder.setSize(320, 100);
        clockLabel.setSize(270, 100);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        clockLabel.setBackground(Color.RED);
        int x =  (panelClock.getWidth() / 2) - (clockLabel.getWidth() / 2);
        int y = (panelClock.getHeight() / 2) - (clockLabel.getHeight() / 2);
        clockLabel.setLocation(x, y);
        add(scroll);
        add(panelClock);
        panelClock.add(clockLabel);

    }

    @Override
    protected void loadContent() {
        remainders = new Remainder().build(Files.getFile(FILE));
        remiandersLabels = new ArrayList<>();
        for (Remainder r : remainders) {
            JLabel l = new JLabel(r.content);
            l.setSize(100, 100);
            remiandersLabels.add(l);
            panelRemainder.add(l);
        }
    }

    @Override
    protected void loadActions() {
    }

    private void changeHour(String date) {
        clockLabel.setText(date);
    }

    private void manageClock() {
        new Thread() {
            public void run() {
                while (true) {
                    Date date = new Date();
                    changeHour(dateFormat.format(date));
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                    res += helper;
                }
            }
            return res;
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

}