package onboard.ecobee.com.tasklist.application;


import android.app.Application;

import java.util.Set;

import javax.inject.Inject;

public class TaskApplication extends Application {

    private ApplicationComponent component;

    @Inject
    Set<Startable> startables;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.create();
        component.inject(this);
        for (Startable startable : startables) {
            startable.start();
        }
    }

    public ApplicationComponent getComponent(){
        return this.component;
    }
}
