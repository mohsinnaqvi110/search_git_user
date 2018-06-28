package co.appdev.search.ui.search;

import android.content.Context;

import javax.inject.Inject;

import co.appdev.search.data.DataManager;
import co.appdev.search.data.model.UserData;
import co.appdev.search.injection.ApplicationContext;
import co.appdev.search.injection.ConfigPersistent;
import co.appdev.search.ui.base.BasePresenter;
import co.appdev.search.util.RxUtil;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@ConfigPersistent
public class SearchPresenter extends BasePresenter<SearchMvpView> {

    private final DataManager mDataManager;
    private final Context context;
    private Subscription mSubscription;

    @Inject
    public SearchPresenter(@ApplicationContext Context context, DataManager dataManager) {
        mDataManager = dataManager;
        this.context = context;
    }

    @Override
    public void attachView(SearchMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void searchUserData(String text) {

        RxUtil.unsubscribe(mSubscription);
        mSubscription = mDataManager.getRibotsService().getUsers(text)

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserData userData) {
                        getMvpView().showData(userData);

                     }
                });
    }
}
