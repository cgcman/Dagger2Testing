package com.grdj.daggerexample.login;

public class LoginActivityModel implements LoginActivityMVP.Model{

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository){
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        /// aqui va la logica antes de guardar
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        /// aqui va la logica antes de guardar
        return repository.getUser();
    }
}
