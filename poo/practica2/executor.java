import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class executor {

    public static void main(String[] args) {
        new Panel();
    }

}

class Remainder {

    public enum Repetable {
        DAILY, WEEKLY, MONTHLY, YEARLY,
    }

    private boolean shouldRepeat;
    private String hour;
    private String day;
    private Repetable isRepatable;

    public boolean isShouldRepeat() {
        return shouldRepeat;
    }

    public Repetable getIsRepatable() {
        return isRepatable;
    }

    public void setIsRepatable(Repetable isRepatable) {
        this.isRepatable = isRepatable;
    }

    public void setShouldRepeat(boolean shouldRepeat) {
        this.shouldRepeat = shouldRepeat;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}

class Panel extends JFrame implements ActionListener {

    private static final long serialVersionUID = -6691512838218834379L;


    public Panel() {


    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}

abstract class Controller {

    public Controller(){

    }

    
}


 class Clock extends Thread {

    public Clock(){
        super();
    }

    @Override
    public void run(){

    }
}

 class Files {

    protected String getFile(String path) throws FileNotFoundException, IOException {
        String res = "";
        String helper = "";
        try (BufferedReader stdInput = new BufferedReader(new FileReader(path))) {
            while ((helper = stdInput.readLine()) != null) {
                res += helper;
            }
        }
        return res;
    }
    protected String saveFile(String name, String ext, List<String> content) throws IOException {
        Path file = Paths.get(name + ext);
        Files.write(file, content, Charset.forName("UTF-8"));
        return name + ext;
    }

}