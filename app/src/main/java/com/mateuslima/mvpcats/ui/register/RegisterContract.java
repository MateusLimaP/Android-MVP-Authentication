package com.mateuslima.mvpcats.ui.register;

public interface RegisterContract {

    interface Interactor{
        interface CreateAccount{
            void createSuccess();
            void errorEmailAlreadyExist();
        }

        void createAccount(CreateAccount createAccount, String name, String email, String password);
    }

    interface View{
        void createAccountSuccess();
        void errorEmailAlreadyExist();
        void emptyNameField();
        void emptyEmailField();
        void emptyPasswordField();
    }

    interface Presenter{
        void setData(String name, String email, String password);
    }
}
