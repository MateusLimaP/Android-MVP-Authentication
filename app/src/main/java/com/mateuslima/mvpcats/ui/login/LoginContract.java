package com.mateuslima.mvpcats.ui.login;

import com.mateuslima.mvpcats.data.db.model.User;

public interface LoginContract {

    interface Interactor{
        interface CheckCredentials{
            void loginSuccess();
            void loginError();
        }
        void checkCredentials(CheckCredentials checkCredentials, String email, String password);
    }

    interface View{
        void loginSuccess();
        void emptyEmailField();
        void emptyPasswordField();
        void loginError();
    }

    interface Presenter{
        void setEmailAndPassword(String email, String password);
    }
}
