/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

/**
 * This class retrieves the information for a user logging in.
 * If the username or password is not the right length, an error message will be displayed.
 * @author aruns
 */

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotNull
    @Size(min=5, max=30, message = "Username size should be in the range [5...30]")
    private String username;

    @NotNull
    @Size(min=1, max=50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}