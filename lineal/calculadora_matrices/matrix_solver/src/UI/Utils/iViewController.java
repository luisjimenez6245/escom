/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Utils;

import javax.swing.JFrame;

/**
 *
 * @author lusi
 */
public abstract class iViewController extends JFrame {

    public iViewController() {
        loadView();
        loadContent();
        loadActions();
        this.repaint();
    }

    protected abstract void loadView();

    protected abstract void loadContent();

    protected abstract void loadActions();

}
