/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class get the information for a user updating their password.
 * It ensure that the password fields cannot be empty.
 * @author liamkenny
 */
public class ProfileForm {
    
    @NotNull
    @Size(min=5, max=50)
    private String password;
    
    @NotNull
    @Size(min=5, max=50)
    private String prev_password;

    public String getPrev_password() {
        return prev_password;
    }

    public void setPrev_password(String prev_password) {
        this.prev_password = prev_password;
    }
    
   
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
