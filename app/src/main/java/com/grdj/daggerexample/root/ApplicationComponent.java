package com.grdj.daggerexample.root;
import com.grdj.daggerexample.login.LoginActivity;
import com.grdj.daggerexample.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
