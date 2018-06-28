package co.appdev.search.injection.component;

import co.appdev.search.injection.PerActivity;
import co.appdev.search.injection.module.ActivityModule;
import co.appdev.search.ui.base.BaseFragment;
import co.appdev.search.ui.home.HomeActivity;
import co.appdev.search.ui.search.SearchFragment;
import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity homeActivity);
    void inject(BaseFragment baseFragment);
    void inject(SearchFragment searchFragment);


}
