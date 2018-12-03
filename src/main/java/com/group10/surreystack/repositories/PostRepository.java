/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Post;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aruns
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    //List<Post> findLatest5Posts(Pageable pageable);
    
    //@Query("SELECT * FROM Post WHERE tag_id=?")
    public List<Post> findByTag(Long tagId);



}
