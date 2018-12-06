/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

/**
 *
 * @author aruns
 */
public class RegisterForm {
    
    @NotNull
    @Size(min=5, max=30)
    private String username;
    
    

    @NotNull
    @Size(min=5, max=50)
    private String password;
    
    
    @NotNull
    @Size(min=5, max=50)
    private String name;
    
    public RegisterForm(){
        System.out.println("made it to the register form!");
        if(name == null ){
            System.out.println("name: null");
            System.out.println("username: null");
            System.out.println("password: null" + "\n");
        }else{
            System.out.println("name: "+ name);
            System.out.println("username: "+ username);
            System.out.println("password: "+ password + "\n");
        }
        
    }

    
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
