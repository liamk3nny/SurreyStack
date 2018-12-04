/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author aruns
 */

public class UserServiceStubImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    @Override
//    public boolean authenticate(String username, String password) {
//         // Provide a sample password check: username == password
//         return Objects.equals(username, password);
//    }
}
