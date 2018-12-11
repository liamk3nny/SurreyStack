/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * This class retrieves the information for a user registering.
 * If the username or password is not the right length or is empty, an error message will be displayed.
 * @author aruns
 */
public class RegisterForm {

    @NotEmpty(message = "Please enter a username")
    @Size(min=5, max=30, message = "Username size should be in the range [5...30]")
    private String username;
    
    @NotEmpty(message = "Please enter a password")
    @Size(min=5, max=50, message = "password size should be greater than 5 characters")
    private String password;
    
    @NotEmpty(message = "Please enter your name")
    @Size(min=5, max=50)
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
