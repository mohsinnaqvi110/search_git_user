package co.appdev.search.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.appdev.search.data.DataManager;
import co.appdev.search.data.remote.RibotsService;
import co.appdev.search.injection.ApplicationContext;
import co.appdev.search.injection.module.ApplicationModule;
import co.appdev.search.util.RxEventBus;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    RibotsService ribotsService();
    DataManager dataManager();
    RxEventBus eventBus();

}
