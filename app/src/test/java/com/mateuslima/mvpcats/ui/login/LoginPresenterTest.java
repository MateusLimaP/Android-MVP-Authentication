package com.mateuslima.mvpcats.ui.login;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    private LoginPresenter SUT;

    @Mock
    LoginContract.View viewMock;

    @Mock
    LoginInteractor loginInteractor;

    @Captor
    ArgumentCaptor<String> emailPasswordCaptor;


    @Before
    public void setup(){
        SUT = new LoginPresenter(viewMock, loginInteractor);
    }

    @Test
    public void login_loginsucess(){
        SUT.setEmailAndPassword(EMAIL, PASSWORD);
        verify(loginInteractor).checkCredentials(any(LoginContract.Interactor.CheckCredentials.class),
                emailPasswordCaptor.capture(), emailPasswordCaptor.capture());
        List<String> values = emailPasswordCaptor.getAllValues();
        assertThat(EMAIL, is(values.get(0)));
        assertThat(PASSWORD, is(values.get(1)));
    }

}