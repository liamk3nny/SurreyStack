/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;
import com.group10.surreystack.repositories.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author aruns
 */
@Service
@Transactional
public class UserServiceJpaImpl implements UserService{
    
    private UserRepository userRepository;
    
    @Autowired
    public UserServiceJpaImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    } 
    
    //@Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    
    
}
