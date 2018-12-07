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
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author aruns
 */
@Service
@Transactional
public class UserServiceJpaImpl implements UserService, UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
    public UserServiceJpaImpl(UserRepository userespository){
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
        
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }
    
 
    
}
