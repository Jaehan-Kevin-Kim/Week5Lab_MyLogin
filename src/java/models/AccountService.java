/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 841898
 */
public class AccountService {

    private String username1;
    private String username2;
    private String password;

    public AccountService() {
        username1 = "abe";
        username2 = "barb";
        password = "password";
    }

    public User login(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        if ((username.equals(username1) || username.equals(username2)) && password.equals(this.password)) {

            User user = new User(username, password);

            return user;
        } else {
            return null;
        }

    }

}
