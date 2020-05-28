/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.presenters;

import sources.api.sourceAPI;
import sources.console.sourceConsole;
import sources.files.sourceFiles;
import ui.view.grapherView;

import ui.view.loginView;

/**
 *
 * @author luis
 */
public class factory {

    private static final sourceAPI SOURCEAPI = new sourceAPI();
    private static final sourceConsole SOURCECONSOLE = new sourceConsole();
    private static final sourceFiles SOURCEFILES = new sourceFiles();

    public static loginPresenter createLoginPresenter(loginView view) {
        return new loginPresenter(view, SOURCEAPI);
    }

    public static grapherPresenter creategrapherPresenter(grapherView view) {
        return new grapherPresenter(view, SOURCECONSOLE, SOURCEFILES);
    }

}
