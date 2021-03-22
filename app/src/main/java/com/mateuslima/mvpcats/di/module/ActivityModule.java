package com.mateuslima.mvpcats.di.module;

import com.mateuslima.mvpcats.ui.login.LoginContract;
import com.mateuslima.mvpcats.ui.main.MainContract;
import com.mateuslima.mvpcats.ui.register.RegisterContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private LoginContract.View viewLogin;
    private RegisterContract.View viewRegister;
    private MainContract.View viewMain;

    public ActivityModule(LoginContract.View viewLogin) {
        this.viewLogin = viewLogin;
    }

    public ActivityModule(RegisterContract.View viewRegister) {
        this.viewRegister = viewRegister;
    }

    public ActivityModule(MainContract.View viewMain) {
        this.viewMain = viewMain;
    }

    @Provides
    public LoginContract.View provideView(){
        return viewLogin;
    }

    @Provides
    public RegisterContract.View provideViewRegister(){
        return viewRegister;
    }

    @Provides
    public MainContract.View provideViewMain(){
        return viewMain;
    }
}
