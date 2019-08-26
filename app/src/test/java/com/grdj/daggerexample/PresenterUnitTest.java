package com.grdj.daggerexample;

import com.grdj.daggerexample.login.LoginActivityMVP;
import com.grdj.daggerexample.login.LoginActivityPresenter;
import com.grdj.daggerexample.login.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterUnitTest {

    LoginActivityPresenter presenter;
    User user;

    LoginActivityMVP.Model mocketModel;
    LoginActivityMVP.View mocketView;

    @Before
    public void initialization() {
        mocketModel = mock(LoginActivityMVP.Model.class);
        mocketView = mock(LoginActivityMVP.View.class);

          user = new User("Manolo", "Escobar");

        //when(mocketModel.getUser()).thenReturn(user);
        //when(mocketView.getFirstName()).thenReturn("Antonio");
        //when(mocketView.getLastName()).thenReturn("Banderas");

        presenter = new LoginActivityPresenter(mocketModel);
        presenter.setView(mocketView);
    }

    @Test
    public void noExistInteractionView(){
        presenter.getCurrentUser();
        //verifyZeroInteractions(mocketView);
        verify(mocketView, times(1)).showUserNotAvailable();
    }

    @Test
    public void loadUserFromRepoWhenValidUserIsPresent(){
        when(mocketModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        verify(mocketModel, times(1)).getUser();

        verify(mocketView, times(1)).setFirstName("Manolo");
        verify(mocketView, times(1)).setLastName("Escobar");
        verify(mocketView, never()).showUserNotAvailable();
    }

    @Test
    public void showErrorMesaggeWhenUserIsNull(){
        when(mocketModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        verify(mocketView, times(1)).showUserNotAvailable();
    }

    @Test
    public void createErrorMesageIfAnyFieldIsEmpty(){
        when(mocketView.getFirstName()).thenReturn("");
        when(mocketView.getLastName()).thenReturn("Banderas");
        presenter.loginButtonClicked();
        verify(mocketView, times(1)).showInputError();
    }
}