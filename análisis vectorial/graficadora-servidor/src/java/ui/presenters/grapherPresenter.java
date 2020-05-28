package ui.presenters;

import controllers.security.manager;
import objects.Parametrics;
import repositories.repositoryConsole;
import repositories.repositoryFiles;
import ui.view.grapherView;

/**
 *
 * @author luis
 */
public class grapherPresenter {

    private final grapherView view;
    private final repositoryConsole source;
    private final repositoryFiles fsource;
    private Parametrics param;
    private String na;

    public grapherPresenter(grapherView view, repositoryConsole source, repositoryFiles fsource) {
        this.view = view;
        this.source = source;
        this.fsource = fsource;
    }

    public void onGetExec(String command) {
        this.view.showRes(fsource.readFile(source.test(command)), "");
    }

    public void onClickGraph(Parametrics parametrics) {
        String res = "";
        String name = parametrics.s + parametrics.t + parametrics.x + parametrics.y + parametrics.z + "/";
        name = name.replace(" ", "").replace("/", "").replace(".", "").replace("(", "").replace(")", "").replace(",", "-");
        name += "/";
        name = "/Users/luis/Desktop/docs/" + manager.APPNAME + "/" + name;
        parametrics.forPython();
        if (this.fsource.createDirectory(name)) {
            parametrics.point = 0;
            if (parametrics.type.equals("2d")) {
                res = source.get2d(parametrics, name + 0 + ".html");
            } else {
                if (parametrics.type.equals("3d")) {
                    res = source.get3d(parametrics, name + 0 + ".html");
                } else {
                    res = source.getSurface(parametrics, name + 0 + ".html");
                }
            }
            this.param = parametrics;
            name = "0";

        } else {
            if (parametrics.point > -1) {
                parametrics.points = parametrics.points / 10;
                parametrics.point = parametrics.point % 10;
                if (parametrics.type.equals("2d")) {
                    parametrics.point = parametrics.point * 100;
                } else {
                    if (parametrics.type.equals("3d")) {

                        parametrics.point = parametrics.point * 10;
                    }
                }
                res = name + parametrics.point + ".html";
            } else {
                res = name + 0 + ".html";
                name = "0";
            }
        }
        if (!res.equals("")) {
            res = fsource.readFile(res);
            this.view.showRes(res, name);
        } else {
            this.view.showError("Ocurrió un error");
        }
    }

    public void onSelectChange(String opt) {
        if (opt.equals("2d")) {
            this.view.on2dGraph();
        } else {
            if (opt.equals("surface")) {
                this.view.onSurfaceGraph();
            } else {
                this.view.on3dGraph();
            }
        }
    }

    public void onSurfaceDisplay() {
    }

    public void on2dDisplay() {
    }

    public void on3dDisplay() {
    }

    private void genGraphs(Parametrics parametrics, String name) {
        parametrics.point = 0;
        parametrics.points = parametrics.points / 10;
        int i = 10;
        if (parametrics.type.equals("2d")) {
            while (i <= parametrics.points) {
                parametrics.point = i * 100;
                source.get2dAsync(parametrics, name + parametrics.point + ".html");
                i += 10;
            }
        } else {
            if (parametrics.type.equals("3d")) {
                while (i <= parametrics.points) {
                    parametrics.point = i * 10;
                    source.get3dAsync(parametrics, name + parametrics.point + ".html");
                    i += 10;
                }
            } else {
                source.getSurface(parametrics, name + 0 + ".html");
                while (i <= parametrics.points) {
                    parametrics.point = i;
                    source.getSurfaceAsync(parametrics, name + parametrics.point + ".html");
                    i += 10;
                }
            }
        }
    }
}
