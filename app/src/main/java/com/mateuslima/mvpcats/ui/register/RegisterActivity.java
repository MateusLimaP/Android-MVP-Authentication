package com.mateuslima.mvpcats.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mateuslima.mvpcats.R;
import com.mateuslima.mvpcats.di.component.DaggerActivityComponent;
import com.mateuslima.mvpcats.di.module.ActivityModule;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    private EditText editName, editPassword, editEmail;
    @Inject
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUi();

        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    public void register(View view){
        presenter.setData(editName.getText().toString(),
                          editEmail.getText().toString(),
                          editPassword.getText().toString());
    }

    private void initUi(){
        editName = findViewById(R.id.editNameRegister);
        editPassword = findViewById(R.id.editPasswordRegister);
        editEmail = findViewById(R.id.editEmailRegister);

    }

    @Override
    public void emptyNameField() {
        editName.setError("Empty Field");
    }

    @Override
    public void emptyEmailField() {
        editEmail.setError("Empty Field");
    }

    @Override
    public void emptyPasswordField() {
        editPassword.setError("Empty Field");
    }

    @Override
    public void createAccountSuccess() {
        Toast.makeText(RegisterActivity.this, "Account successfully created", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void errorEmailAlreadyExist() {
        editEmail.setError("Email already exist");
    }
}
