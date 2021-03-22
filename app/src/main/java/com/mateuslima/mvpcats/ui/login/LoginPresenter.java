package com.mateuslima.mvpcats.ui.login;

import com.mateuslima.mvpcats.data.db.model.User;

import javax.inject.Inject;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Interactor.CheckCredentials{

    private LoginContract.View view;
    private LoginContract.Interactor interactor;

    @Inject
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        interactor = new LoginInteractor();
    }

    @Override
    public void setEmailAndPassword(String email, String password) {
        if (!email.isEmpty()){
            if (!password.isEmpty()){

                interactor.checkCredentials(this, email, password);

            }else{
                view.emptyPasswordField();
            }
        }else{
            view.emptyEmailField();
        }

    }

    @Override
    public void loginSuccess() {
        view.loginSuccess();
    }

    @Override
    public void loginError() {
        view.loginError();
    }
}
