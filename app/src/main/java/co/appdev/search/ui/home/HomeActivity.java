package co.appdev.search.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.appdev.fragmentnavigation.FragNavController;

import javax.inject.Inject;

import butterknife.ButterKnife;
import co.appdev.search.R;
import co.appdev.search.ui.base.BaseActivity;
import co.appdev.search.ui.search.SearchFragment;


public class HomeActivity extends BaseActivity implements HomeMvpView {


    @Inject
    HomePresenter homePresenter;

    private BaseActivity baseActivity;
    private ProgressDialog myDialog;

    @Override
    public void initViews(Bundle savedInstanceState) {
        baseActivity = (BaseActivity) this;
        baseActivity.activityComponent().inject(this);
        ButterKnife.bind(this);
        homePresenter.attachView(this);
        myDialog = new ProgressDialog(this);

        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.container)
                .transactionListener(this)
                .rootFragment(new SearchFragment())
                .build();


    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void pushFragment(Fragment fragment, boolean detach) {

    }

    @Override
    public void replaceFragment(Fragment fragment) {

    }

    @Override
    public void navigationTitle(Fragment fragment) {

    }

    @Override
    public void popCurrentFragment() {
        mNavController.popFragment();


    }

    @Override
    public void onTabTransaction(Fragment fragment, int index) {

    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {

    }



}
