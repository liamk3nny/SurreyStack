/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author ikamp
 */
@Service
public class ProfileServiceStubImpl implements ProfileService{

    private User user = new User(5L, "username1", "Ignas Kampas");
    
    
    
    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public String getFullName() {
        return this.user.getFullName();
    }
    
    @Override
    public Long getUserId(){
        return this.user.getUser_id();
    }
    
}
