package com.mateuslima.mvpcats;

import android.app.Application;

import com.mateuslima.mvpcats.di.component.ApplicationComponent;
import com.mateuslima.mvpcats.di.component.DaggerApplicationComponent;
import com.mateuslima.mvpcats.di.module.ApplicationModule;

public class MvpApplication extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

       component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
