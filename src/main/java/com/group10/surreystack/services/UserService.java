/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;

/**
 *
 * @author aruns
 */
public interface UserService {
       // boolean authenticate(String username, String password);
    
    public User findByUsername(String username);

}
