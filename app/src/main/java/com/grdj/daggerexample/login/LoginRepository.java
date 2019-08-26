package com.grdj.daggerexample.login;

public interface LoginRepository {
    void saveUser(User user);

    User getUser();
}
