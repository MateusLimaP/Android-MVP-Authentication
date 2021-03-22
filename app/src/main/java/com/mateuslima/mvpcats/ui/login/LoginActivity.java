package com.mateuslima.mvpcats.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mateuslima.mvpcats.R;
import com.mateuslima.mvpcats.data.db.model.User;
import com.mateuslima.mvpcats.di.component.DaggerActivityComponent;
import com.mateuslima.mvpcats.di.module.ActivityModule;
import com.mateuslima.mvpcats.ui.main.MainActivity;
import com.mateuslima.mvpcats.ui.register.RegisterActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText editEmail, editPassword;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUi();

        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build().inject(this);

    }

    public void createAnAccount(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void login(View view){
        presenter.setEmailAndPassword(editEmail.getText().toString(), editPassword.getText().toString());
    }

    private void initUi(){
        editEmail = findViewById(R.id.editEmailLogin);
        editPassword = findViewById(R.id.editPasswordLogin);
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }

    @Override
    public void loginError() {
        Toast.makeText(LoginActivity.this, "Invalid Credentials...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emptyEmailField() {
        editEmail.setError("Empty Field");
    }

    @Override
    public void emptyPasswordField() {
        editPassword.setError("Empty Field");
    }
}
