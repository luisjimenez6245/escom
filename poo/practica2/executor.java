
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

class Remainder {

    public boolean shouldRepeat;
    public String hour;
    public String day;
    public Repetable isRepatable;
    public String content;
    public State state;

    public enum Repetable {
        DAILY, WEEKLY, MONTHLY, YEARLY,
    }

    public enum State {
        COMPLETED, TOCOMPLETE, LATE,
    }

    public Remainder() {
    }

    public Remainder[] build(String json) {
        List<Remainder> res = new ArrayList<>();
        String list[] = json.split("\n");
        for (String l : list) {
            Remainder r = new Remainder().buildSelf(l);
            if (r != null) {
                res.add(r);
            }
        }
        return res.toArray(new Remainder[res.size()]);
    }

    public Remainder buildSelf(String json) {
        String helper[] = json.split("&&%");
        try {
            this.shouldRepeat = Boolean.parseBoolean(helper[3]);
            this.isRepatable = Repetable.valueOf(helper[0]);
            this.hour = helper[1];
            this.day = helper[2];
            this.content = helper[4];
            return this;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

}

class Panel extends Controller {

    private static final String FILE = "/Users/luis/Documents/GitHub/escom/poo/practica2/remainder.txt";
    private static final SimpleDateFormat TODATE = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final long serialVersionUID = 1L;
    private JLabel clockLabel;
    private JLabel dateLabel;
    private List<JLabel> remiandersLabels;
    private Remainder[] remainders;
    private JPanel panelRemainder;
    private DateFormat hourFormat;
    private DateFormat dateFormat;

    public Panel() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        manageClock();
    }

    @Override
    protected void loadView() {
        JPanel panelClock = new JPanel();
        hourFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        setTitle("Reloj");
        setVisible(true);
        setLayout(null);
        setSize(320, 320);
        panelClock = new JPanel();
        panelRemainder = new JPanel();
        dateLabel = new JLabel("");
        clockLabel = new JLabel("");
        panelClock.setBounds(0, 20, 320, 100);
        panelRemainder.setLocation(0, 0);
        JScrollPane scroll = new JScrollPane(panelRemainder, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0, 100, 320, 220);
        panelRemainder.setLayout(new BoxLayout(panelRemainder, BoxLayout.Y_AXIS));
        clockLabel.setSize(270, 8);
        dateLabel.setSize(270, 100);
        int x = (panelClock.getWidth() / 2) - (clockLabel.getWidth() / 2);
        int y = (panelClock.getHeight() / 2) - (clockLabel.getHeight() / 2);
        clockLabel.setLocation(x, y);
        dateLabel.setLocation(x, y + 100);
        add(scroll);
        add(panelClock);
        panelClock.add(clockLabel);
        panelClock.add(dateLabel);
    }

    @Override
    protected void loadContent() {
        clockLabel.setBackground(Color.RED);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 5));
        remainders = new Remainder().build(Files.getFile(FILE));
    }

    @Override
    protected void loadActions() {
        remiandersLabels = new ArrayList<>();
        load(new Date());
    }

    private void load(Date date) {
        List<Remainder> toReplace = new ArrayList<>();
        for (Remainder r : remainders) {
            toReplace.add(getState(date, r));
        }
        this.remainders = toReplace.toArray(new Remainder[toReplace.size()]);
        Font f =   new Font("Arial", Font.PLAIN, 25);
        for (Remainder r : remainders) {
            JLabel l;
            if (r.state.equals(Remainder.State.COMPLETED))
                l = new JLabel(r.content, SwingConstants.CENTER);
            else
                l = new JLabel(r.content, SwingConstants.CENTER);
            l.setSize(320, 100);
            l.setFont(f);
            l.setHorizontalAlignment(SwingConstants.CENTER);
            l.setVerticalAlignment(SwingConstants.CENTER);
            l.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel source = (JLabel) e.getSource();
                    int i = 0;
                    for (i = 0; i < remiandersLabels.size(); ++i) {
                        if (remiandersLabels.get(i).equals(source)) {
                            Remainder r = remainders[i];
                            JOptionPane.showMessageDialog(rootPane, r.content);
                        }
                    }
                }
            });
            remiandersLabels.add(l);
            panelRemainder.add(l);
        }
    }

    private void changeHour(Date date) {
        clockLabel.setText(hourFormat.format(date));
        dateLabel.setText(dateFormat.format(date));
        List<Remainder> toReplace = new ArrayList<>();
        for (Remainder r : remainders) {
            toReplace.add(getState(date, r));
        }
        this.remainders = toReplace.toArray(new Remainder[toReplace.size()]);
    }

    private Remainder getState(Date date, Remainder remainder) {
        try {
            Date dateRemainder = TODATE.parse(remainder.day + ' ' + remainder.hour);
            if (date.toString().equals(dateRemainder.toString())) {
                JOptionPane.showMessageDialog(rootPane, "Es hora de: " + remainder.content);
             } else {
                if (remainder.shouldRepeat) {
                    dateRemainder = TODATE.parse(remainder.day + ' ' + remainder.hour);
                    remainder.state = Remainder.State.COMPLETED;
                    if (date.compareTo(dateRemainder) == 0) {

                        JOptionPane.showMessageDialog(rootPane, "alv");
                    }
                } else {
                    dateRemainder = TODATE.parse(remainder.day + ' ' + remainder.hour);
                    if (date.compareTo(dateRemainder) > 0) {
                        remainder.state = Remainder.State.LATE;
                    } else {
                        if (date.compareTo(dateRemainder) < 0) {
                            remainder.state = Remainder.State.TOCOMPLETE;
                        } else {
                            System.out.println("kjsndjas");
                        }
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return remainder;
    }

    private void manageClock() {
        new Thread() {
            public void run() {
                while (true) {
                    changeHour(new Date());
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
                    res += helper + "\n";
                }
            }
            return res;
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

}