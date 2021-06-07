package com.mateuslima.mvpcats.ui.register;

import javax.inject.Inject;

public class RegisterPresenter implements RegisterContract.Presenter, RegisterContract.Interactor.CreateAccount {

    private RegisterContract.View view;
    private RegisterInteractor interactor;

    @Inject
    public RegisterPresenter(RegisterContract.View view, RegisterInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void setData(String name, String email, String password) {
        if (!name.isEmpty()){
            if (!email.isEmpty()){
                if (!password.isEmpty()){

                    interactor.createAccount(this, name, email, password);

                }else{
                    view.emptyPasswordField();
                }
            }else{
                view.emptyEmailField();
            }
        }else{
            view.emptyNameField();
        }

    }

    @Override
    public void createSuccess() {
        view.createAccountSuccess();
    }

    @Override
    public void errorEmailAlreadyExist() {
        view.errorEmailAlreadyExist();
    }
}
