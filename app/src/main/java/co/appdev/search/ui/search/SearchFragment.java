package co.appdev.search.ui.search;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;

import javax.inject.Inject;

import butterknife.BindView;
import co.appdev.search.R;
import co.appdev.search.data.model.UserData;
import co.appdev.search.ui.base.BaseFragment;
import co.appdev.search.util.DialogFactory;


public class SearchFragment extends BaseFragment implements SearchMvpView, SearchView.OnQueryTextListener {

    @BindView(R.id.search)
    SearchView search;
    @BindView(R.id.result_list)
    RecyclerView list;
    @Inject
    SearchPresenter searchPresenter;
    private SearchAdapter searchAdapter;
    private ProgressDialog myDialog;

    @Override
    public void initViews(View parentView) {
        baseActivity.activityComponent().inject(this);
        searchPresenter.attachView(this);
        myDialog = new ProgressDialog(getActivity());

        setupSearchView();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        searchPresenter.searchUserData(newText);

        myDialog = DialogFactory.showProgressDialog(getActivity(), getActivity().getResources().getString(R.string.fetching),getActivity().getResources().getString(R.string.wait));
        myDialog.show();

        return false;
    }

    @Override
    public void showData(UserData userData) {
        myDialog.dismiss();
        searchAdapter = new SearchAdapter(userData.getUsers(), getActivity());
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(searchAdapter);

    }


    private void setupSearchView() {
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setSubmitButtonEnabled(true);
        search.setQueryHint(getActivity().getResources().getString(R.string.search));
    }

}
