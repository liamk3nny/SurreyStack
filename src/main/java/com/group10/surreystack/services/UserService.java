/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.User;

/**
 * Interface for UserServiceJpaImpl
 * @author aruns
 */
public interface UserService {

    public User findByUsername(String username);

    public User create(User user);

    void deleteById(Long id);

    public User save(User user);

}
