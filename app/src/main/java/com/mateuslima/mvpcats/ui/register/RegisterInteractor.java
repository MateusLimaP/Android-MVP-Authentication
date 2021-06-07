package com.mateuslima.mvpcats.ui.register;

import android.content.Context;

import com.mateuslima.mvpcats.MvpApplication;
import com.mateuslima.mvpcats.data.db.UserDatabase;
import com.mateuslima.mvpcats.data.db.dao.UserDao;
import com.mateuslima.mvpcats.data.db.model.User;

import javax.inject.Inject;

public class RegisterInteractor implements RegisterContract.Interactor {

    private Context context;
    private UserDao userDao;

    @Inject
    public RegisterInteractor() {
    }

    @Override
    public void createAccount(CreateAccount createAccount, String name, String email, String password) {
        context = MvpApplication.getComponent().getContext();
        UserDatabase database = UserDatabase.getInstance(context);
        userDao = database.userDao();

        User userEmail = userDao.checkEmail(email);
        if (userEmail == null){

            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(password);
            userDao.insert(newUser);
            createAccount.createSuccess();

        }else{
            createAccount.errorEmailAlreadyExist();
        }

    }
}
