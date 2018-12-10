/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This class creates a JPA repository for a User object, which helps find Users
 * in the database
 *
 * @author aruns
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Method to find a user in the database based on the their username.
     *
     * @param username
     * @return
     */
    public User findByUsername(@Param("username") String username);

}
