package objects;

/**
 *
 * @author luis
 */
public class Parametrics {

    public String type;
    public String x;
    public String y;
    public String z;
    public String t;
    public String s;
    public int points;
    public int point;

    public Parametrics(String type) {
        this.type = type;
    }

    public Parametrics build(String x, String y, String z, String t, String s, int point) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
        this.s = s;
        this.point = point;
        return this;
    }

    public void forPython() {
        this.type = type.toLowerCase();
        this.x = replace(this.x);
        this.y = replace(this.y);
        this.z = replace(this.z);
        this.t = lineSpace(replace(this.t));
        this.s = lineSpace(replace(this.s));
    }

    private String lineSpace(String toReplace) {
        if (toReplace != null && !toReplace.equals("")) {
            if (this.type.equals("surface")) {
                this.points = 100;
            }
            if (this.type.equals("2d")) {
                this.points = 10000;
            }
            if (this.type.equals("3d")) {
                this.points = 1000;
            }
            return "np.linspace(" + toReplace + ", " + this.points + ")";
        }
        return "";
    }

    private String replace(String toReplace) {
        toReplace = toReplace.toLowerCase();
        toReplace = toReplace.replace(" ", "")
                .replace("sen", "sin")
                .replace("sin", "np.sin")
                .replace("cos", "np.cos")
                .replace("tan", "np.tan")
                .replace("cot", "np.cot")
                .replace("sec", "np.sec")
                .replace("csc", "np.csc")
                .replace("pi", "np.pi")
                .replace("", "");
        return toReplace;
    }

}
