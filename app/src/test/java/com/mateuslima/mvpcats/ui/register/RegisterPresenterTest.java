package com.mateuslima.mvpcats.ui.register;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterPresenterTest {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    private RegisterPresenter SUT;

    @Mock
    RegisterContract.View viewMock;

    @Mock
    RegisterInteractor interactorMock;

    @Before
    public void setup(){
        SUT = new RegisterPresenter(viewMock, interactorMock);
    }


    @Test
    public void register_sucess(){
        SUT.setData(NAME, EMAIL, PASSWORD);
        ArgumentCaptor<String> ag = ArgumentCaptor.forClass(String.class);
        verify(interactorMock).createAccount(any(RegisterContract.Interactor.CreateAccount.class), ag.capture(), ag.capture(),ag.capture());
        List<String> values = ag.getAllValues();
        assertThat(NAME, is(values.get(0)));
        assertThat(EMAIL, is(values.get(1)));
        assertThat(PASSWORD, is(values.get(2)));
    }


}