package com.mateuslima.mvpcats.ui.login;

import android.content.Context;
import com.mateuslima.mvpcats.MvpApplication;
import com.mateuslima.mvpcats.data.db.UserDatabase;
import com.mateuslima.mvpcats.data.db.dao.UserDao;
import com.mateuslima.mvpcats.data.db.model.User;

import javax.inject.Inject;


public class LoginInteractor implements LoginContract.Interactor {

    private Context context;
    private UserDao userDao;

    @Inject
    public LoginInteractor() {
    }

    @Override
    public void checkCredentials(CheckCredentials checkCredentials, String email, String password) {
        context = MvpApplication.getComponent().getContext();
        UserDatabase database = UserDatabase.getInstance(context);
        userDao = database.userDao();
        User user = userDao.login(email, password);
        if (user != null){
            checkCredentials.loginSuccess();
        }else{
            checkCredentials.loginError();
        }

    }
}
