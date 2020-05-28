package ui.controllers;

import repositories.repositoryRequest;
import ui.presenters.factory;
import ui.presenters.grapherPresenter;
import ui.view.grapherView;

/**
 *
 * @author luis
 */
public class grapherController extends iViewController implements grapherView {
    
    private final String container = ""
            + "         <div class=\"graph-input\" class=\"col-md-3 col-lg-3\" style=\"height: 100vh;\">\n"
            + "            <div class=\"col-md-12\" style=\"\">\n"
            + "                <div class=\"col-md-12\">\n"
            + "                    <div class=\"form-row form-group\">\n"
            + "                        <label for=\"select-input\">Tipo de gráfica</label>\n"
            + "                        <select id=\"select\" onchange=\"handleSelect(event)\" class=\"form-control form-control-sm\">\n"
            + "                            <option value=\"3d\">Vector en 3d</option>\n"
            + "                            <option value=\"surface\">Superficie</option>\n"
            + "                            <option value=\"2d\">Vector en 2d</option>\n"
            + "                        </select>\n"
            + "                    </div>\n"
            + "                    <div id=\"inputs\">\n"
            + "                         $content$"
            + "                    </div>\n"
            + "                </div>\n"
            + "            </div>\n"
            + "        </div>\n"
            + "        <div id='graph-content' class=\"col-md-9 container\" style=\"height: 100vh;\">\n"
            + "            &nbsp;\n"
            + "        </div>";
    
    private final String container2d = ""
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">T values</label>\n"
            + "                            <input type='text' id='t_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">S values</label>\n"
            + "                            <input type='text' id='s_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row  form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica X</label>\n"
            + "                            <input type='text' id='x_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica Y</label>\n"
            + "                            <input type='text' id='y_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <input onclick='graph()' type='button' value='Gráficar'\n"
            + "                                class=\"form-control form-control-sm btn btn-primary mb-2\"></input>\n"
            + "                        </div>\n";
    
    private final String container3d = ""
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">T values</label>\n"
            + "                            <input type='text' id='t_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">S values</label>\n"
            + "                            <input type='text' id='s_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row  form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica X</label>\n"
            + "                            <input type='text' id='x_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica Y</label>\n"
            + "                            <input type='text' id='y_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica Z</label>\n"
            + "                            <input type='text' id='z_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <input onclick='graph()' type='button' value='Gráficar'\n"
            + "                                class=\"form-control form-control-sm btn btn-primary mb-2\"></input>\n"
            + "                        </div>\n";
    
    private final String containerSurface = ""
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">T values</label>\n"
            + "                            <input type='text' id='t_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group \">\n"
            + "                            <label for=\"select-input\">S values</label>\n"
            + "                            <input type='text' id='s_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row  form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica X</label>\n"
            + "                            <input type='text' id='x_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica Y</label>\n"
            + "                            <input type='text' id='y_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <label for=\"select-input\">Paramétrica Z</label>\n"
            + "                            <input type='text' id='z_val' class=\"form-control form-control-sm\"></input>\n"
            + "                        </div>\n"
            + "                        <div class=\"form-row form-group\">\n"
            + "                            <input onclick='graph()' type='button' value='Gráficar'\n"
            + "                                class=\"form-control form-control-sm btn btn-primary mb-2\"></input>\n"
            + "                        </div>\n";
    
    private final grapherPresenter presenter;
    
    public grapherController(repositoryRequest rSource) {
        super(rSource);
        this.presenter = factory.creategrapherPresenter(this);
    }
    
    @Override
    public void main() {
        String action = rSource.getAction();
        if (action.equals("exec")) {
            presenter.onClickGraph(rSource.getParametrics());
        } else {
            if (action.equals("")) {
                this.view("");
            } else {
                if (action.equals("option")) {
                    presenter.onSelectChange(rSource.getOption());
                } else {
                }
            }
        }
    }
    
    @Override
    public void view(String content) {
        this.content = this.container.replace("$content$", container3d);
    }
    
    @Override
    public void showRes(String res, String name) {
        res = res.replace("<div>", "<div style='width:100%;height: 100vh; background-color:red'>");
        scriptsFinal = ""
                + "<script>\n"
                + "$('#graph-content').html('');\n";
        if (name.contains("0")) {
            //scriptsFinal += "window.setTimeout(animate, 2000);\n";
        }
        scriptsFinal += "</script>\n";
        
        content = ""
                + res;
        modal = "#graph-content";
    }
    
    @Override
    public void on3dGraph() {
        scriptsFinal = ""
                + "<script>\n"
                + "$('#inputs').html('');\n"
                + "</script>\n";
        content = container3d;
        modal = "#inputs";
    }
    
    @Override
    public void on2dGraph() {
        scriptsFinal = ""
                + "<script>\n"
                + "$('#inputs').html('');"
                + "</script>\n";
        content = container2d;
        modal = "#inputs";
    }
    
    @Override
    public void onSurfaceGraph() {
        scriptsFinal = ""
                + "<script>\n"
                + "$('#inputs').html('');\n"
                + "</script>\n";
        content = containerSurface;
        modal = "#inputs";
    }
    
    @Override
    public void showError(String res) {
        res = "<div>\n" + res + "</div>\n";
        res = res.replace("<div>", "<div style='width:100%;height: 100vh; background-color:red'>");
        scriptsFinal = ""
                + "<script>\n"
                + "$('#graph-content').html('');\n"
                + "</script>\n";
        content = ""
                + res;
        modal = "#graph-content";
    }
    
}
