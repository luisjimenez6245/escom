/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import java.util.Base64;
import java.util.Base64.Encoder;
import objects.User;
import repositories.repositoryRequest;
import ui.presenters.factory;
import ui.presenters.loginPresenter;
import ui.view.loginView;

/**
 *
 * @author luis
 */
public class loginController extends iViewController implements loginView {

    private final loginPresenter presenter;

    private final String container = " <div class='container-login' >\n"
            + "                <div class='float'>\n"
            + "                    <div class='container-form form-control form'>\n"
            + "                        <div class='header'>\n"
            + "                            <div class='title'>\n"
            + "                                Acceso\n"
            + "                            </div>\n"
            + "                            <div class='subtitle'>\n"
            + "                                Ingresa tus datos para accesar\n"
            + "                            </div>\n"
            + "                        </div>\n"
            + "                        <div class='container-full'>\n"
            + "                        </div>\n"
            + "                        <form>"
            + "                             <div class='container-full'>\n"
            + "                                 <input type='text' placeholder='Email' id='lbl_emailF' required />\n"
            + "                             </div>\n"
            + "                             <div class='container-full'>\n"
            + "                              </div>\n"
            + "                              <div class='container-full'>\n"
            + "                                    <input type='password' placeholder='Contraseña' id='lbl_pswF' required />\n"
            + "                             </div>\n"
            + "                             <div class='container-full'>\n"
            + "                                 <div class=' button button-middle' onclick='onLoginClick()'>\n"
            + "                                    <label>Accesar</label> \n"
            + "                                 </div>\n"
            + "                             </div>\n"
            + "                             <div class='container-full'>\n"
            + "                                 <div class='button button-middle-clear' onclick='onNoAccountClick()'>\n"
            + "                                     <label>Aún no tengo cuenta</label> \n"
            + "                                 </div>\n"
            + "                             </div>"
            + "                        </form>\n"
            + "                    </div>\n"
            + "                </div>\n"
            + "            </div> <!-- #main -->";

    public loginController(repositoryRequest rSource) {
        super(rSource);
        this.presenter = factory.createLoginPresenter(this);
    }

    @Override
    public void showError() {
        content = "";
        modal = ""
                + "  <div class='blur'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>Error</div>\n"
                + "                    <div>Error de acceso</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                           Ocurrió un error interno, favor de verificar tus datos y volverlo a intentar\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle'  onclick='succesRegister()'>\n"
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
    public void main() {
        String action = rSource.getAction();
        if (action.equals("")) {
            this.view("");
        } else {
            if (action.equals("login")) {
                this.presenter.onLoginClick(rSource.getUser());
            } else {
                if (action.equals("new_account")) {
                    this.presenter.onNewAccountClick();
                } else {
                    if (action.equals("old_account")) {
                        this.presenter.onOldAccountClik();
                    } else {
                        if (action.equals("register")) {
                            this.presenter.onRegisterClick(rSource.getUser());
                        } else {
                            this.showError();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void view(String content) {
        content = container;
        modal = "";
        scripts = "";
        scriptsFinal += "";
    }

    @Override
    public void submit(User user) {
        content = "";
        modal = ""
                + getQueryString(user)
                + "";
        scriptsFinal += "<script>"
                + "hideModal();    $('#active_login').submit();"
                + "</script>";
    }


    private String getQueryString(User user) {
        //x id
        //a name
        //r email
        //t type
        Encoder e = Base64.getEncoder();
        String res = "" + user.id;
        res = ""
                + "<form action='/pharma-ui/log.jsp' method='POST' id='active_login'>\n"
                + "<input type='password' id='x' name='x' value='" + e.encodeToString(res.getBytes()) + "'>"
                + "<input type='password' id='a' name='a' value='" + e.encodeToString(user.name.getBytes()) + "'>"
                + "<input type='password' id='r' name='r' value='" + e.encodeToString(user.email.getBytes()) + "'>"
                + "<input type='password' id='t' name='t' value='" + e.encodeToString(user.type.getBytes()) + "'>"
                + "<input type='password' id='token' name='token' value='" + e.encodeToString(user.token.getBytes()) + "'>"
                + "<input type='password' id='aaa' name='aaa' value='login'/>"
                + "</form>\n";
        return res;
    }

    @Override
    public void showDisableAccount() {
        content = "";
        modal = ""
                + "         <div class='blur'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>Cuenta sin activar</div>\n"
                + "                    <div>A</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                           Hemos enviado un correo electrónico para confirmar tu cuenta, en caso de no aparecer revisa tu correo no deseado.\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle' onclick='hideModal()'>\n"
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
    public void showPasswordError() {
        content = "";
        modal = "";
        scriptsFinal += "<script>"
                + "hideModal();"
                + "</script>";
    }

    @Override
    public void showEmailError() {
        content = "";
        modal = "";
        scriptsFinal += "<script>"
                + "hideModal();"
                + "</script>";
    }

    @Override
    public void newAccount() {
        content = "<div class='container-login'>\n"
                + "\n"
                + "                <div class='float'>\n"
                + "                    <div class='container-form form-control form'>\n"
                + "                        <div class='header'>\n"
                + "                            <div class='title'>\n"
                + "                                Registro\n"
                + "                            </div>\n"
                + "                            <div class='subtitle'>\n"
                + "                                Ingresa tus datos \n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <input type='text' placeholder='Nombre Completo' id='lbl_name'/>\n"
                + "                        </div>\n"
                + "                        \n"
                + "                        <div class='container-full'>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <input type='text'  placeholder='Email' id='lbl_email'/>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <input type='password'  placeholder='Contraseña' id='lbl_psw'/>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <input type='password' placeholder='Confirma Contraseña' id='lbl_cpsw'/>\n"
                + "                        </div>\n"
                + "                        \n"
                + "                        <div class='container-full'>\n"
                + "                            <div class=' button button-middle' onclick='onResgisterClick()'>\n"
                + "                                <label>Registrarme</label> \n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class=' button button-middle-clear' onclick='onHaveAccountClick()'>\n"
                + "                                <label>Ya tengo cuenta</label> \n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div> <!-- #main -->";
        modal = "";
        scriptsFinal += "";
    }

    @Override
    public void showNoAccount() {
        content = "";
        modal = ""
                + "         <div class='blur'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>Datos invalidos</div>\n"
                + "                    <div>&nbsp;</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                           Los datos que ingresaste no son validos, verificalos.\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle' onclick='hideModal()'>\n"
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

}
