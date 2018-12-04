/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aruns
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
