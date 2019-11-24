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
        String action = rSource.getAction();

    }

    @Override
    public void view() {
    }

}
