package co.appdev.search.ui.home;

import javax.inject.Inject;

import co.appdev.search.data.DataManager;
import co.appdev.search.injection.ConfigPersistent;
import co.appdev.search.ui.base.BasePresenter;
import rx.Subscription;

@ConfigPersistent
public class HomePresenter extends BasePresenter<HomeMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public HomePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(HomeMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

}
