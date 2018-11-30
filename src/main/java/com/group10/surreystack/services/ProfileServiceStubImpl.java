/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ikamp
 */
@Service
public class ProfileServiceStubImpl implements ProfileService{

    private User user = new User(5L, "username1", "Ignas Kampas");
    private User user2 = new User(6L, "username2", "Liam Kenny");
    private User user3 = new User(7L, "username3", "Arun Subramanium");
    
    private List<User> users = new ArrayList<User>(){{
        add(user);
        add(user2);
        add(user3);
    }};
    
    @Override
    public User findUserById(Long id){
        User user = null;
        for(User u: users){
            if(u.getId().equals(id)){
                user = new User(id, u.getUsername(), u.getFullName());
            }
        }
        
        return user;
    }
    
}
