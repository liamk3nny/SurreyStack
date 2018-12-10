/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This class creates a JPA repository for a Post object, which helps find Posts
 * in the database
 *
 * @author aruns
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Query to find all posts in the database and order them by date.
     *
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM Post p  ORDER BY p.date DESC")
    public Page<Post> findAll(Pageable pageable);

}
