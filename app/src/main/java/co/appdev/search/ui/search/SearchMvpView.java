package co.appdev.search.ui.search;


import co.appdev.search.data.model.UserData;
import co.appdev.search.ui.base.MvpView;

public interface SearchMvpView extends MvpView {

    void showData(UserData userData);
}
