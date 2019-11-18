package presenters;

import sources.api.repositoryApi;
import views.IndexView;

/**
 *
 * @author luis
 */
public class IndexPresenter {

    private final IndexView view;
    private final repositoryApi source;

    public IndexPresenter(IndexView view, repositoryApi source) {
        this.view = view;
        this.source = source;
    }

}
