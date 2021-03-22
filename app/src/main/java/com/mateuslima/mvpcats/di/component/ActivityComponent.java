package com.mateuslima.mvpcats.di.component;

import com.mateuslima.mvpcats.di.module.ActivityModule;
import com.mateuslima.mvpcats.ui.login.LoginActivity;
import com.mateuslima.mvpcats.ui.main.MainActivity;
import com.mateuslima.mvpcats.ui.register.RegisterActivity;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);
    void inject(RegisterActivity activity);
    void inject(MainActivity activity);
}
