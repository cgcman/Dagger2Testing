package com.grdj.daggerexample.root;

import android.app.Application;

import com.grdj.daggerexample.login.LoginModule;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate(){
        super.onCreate();

        //component = DaggerComp
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
