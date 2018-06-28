package co.appdev.search;

import android.app.Application;
import android.content.Context;

import co.appdev.search.injection.component.ApplicationComponent;
import co.appdev.search.injection.component.DaggerApplicationComponent;
import co.appdev.search.injection.module.ApplicationModule;
import timber.log.Timber;

public class SearchGitApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        //    Fabric.with(this, new Crashlytics());
        }
    }

    public static SearchGitApplication get(Context context) {
        return (SearchGitApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
