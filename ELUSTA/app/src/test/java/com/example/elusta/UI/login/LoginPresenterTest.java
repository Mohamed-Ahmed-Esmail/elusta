package com.example.elusta.UI.login;

import com.example.elusta.Model.LoginPojoModel;
import com.example.elusta.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginMvpView view;
    @Mock
    private LoginPojoModel service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void ShouldShowErrorMassegeWhenUsernameIsEmpty() {
        view.getUsername();
        when(view.getUsername()).thenReturn("");
        presenter.login();
        verify(view).showUsernameError(R.string.Username_Error);
    }

    @Test
    public void ShouldShowErrorMassegeWhenPasswordIsEmpty() {
        when(view.getUsername()).thenReturn("mohamed");
        when(view.getPassword()).thenReturn("");
        presenter.login();
        verify(view).showPasswordError(R.string.Password_Error);
    }




}