package co.appdev.search.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/**
 * Created by ahsan on 5/8/17.
 */

public class RxSchedulersOverrideRule implements TestRule {

    private final RxAndroidSchedulersHook mRxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
        @Override
        public Scheduler getMainThreadScheduler() {
            return Schedulers.immediate();
        }
    };

    private final Func1<Scheduler, Scheduler> mRxJavaImmediateScheduler =
            new Func1<Scheduler, Scheduler>() {
                @Override
                public Scheduler call(Scheduler scheduler) {
                    return Schedulers.immediate();
                }
            };

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.getInstance().reset();
                RxAndroidPlugins.getInstance().registerSchedulersHook(mRxAndroidSchedulersHook);

                RxJavaHooks.reset();
                RxJavaHooks.setOnIOScheduler(mRxJavaImmediateScheduler);
                RxJavaHooks.setOnNewThreadScheduler(mRxJavaImmediateScheduler);

                base.evaluate();

                RxAndroidPlugins.getInstance().reset();
                RxJavaHooks.reset();
            }
        };
    }
}
