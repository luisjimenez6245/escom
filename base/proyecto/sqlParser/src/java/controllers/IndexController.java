package controllers;

import com.google.gson.Gson;
import controllers.utils.iViewController;
import models.Level;
import presenters.IndexPresenter;
import routes.utils.Factory;
import sources.requests.repositoryRequests;
import views.IndexView;

/**
 *
 * @author luis
 */
public class IndexController extends iViewController implements IndexView {

    private final IndexPresenter presenter;

    public IndexController(repositoryRequests rSource) {
        super(rSource);
        presenter = Factory.createIndexPresenter(this);
    }

    @Override
    public void main() {
        String action = rSource.getAction();
        if (action.equals("")) {
            this.presenter.loadView();
        } else {
            content = "hola";
        }
    }

    @Override
    public void view() {
        modal = ""
                + "         <div class='blur'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>Éxito</div>\n"
                + "                    <div>Tu información se guradó exitosamente</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                             Tus datos fueron cambiados y almacenados correctamente en la aplicación."
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle'  onclick='hideModal()'>\n"
                + "                                <label>Aceptar</label>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>";
        scriptsFinal += "<script>"
                + "hideModal();"
                + "showModal();"
                + "</script>";
    }

    @Override
    public void showLevels(Level[] levels) {
        content = new Gson().toJson(levels);
    }

}
