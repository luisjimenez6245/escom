package controllers;

import controllers.utils.iViewController;
import sources.requests.repositoryRequests;
import views.IndexView;

/**
 *
 * @author luis
 */
public class IndexController extends iViewController implements IndexView {

    public IndexController(repositoryRequests rSource) {
        super(rSource);
    }

    @Override
    public void main() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
