/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aruns
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //  @Query("SELECT p FROM Post p  ORDER BY p.date DESC")
    //  List<Post> findLatest5Posts(Pageable pageable);
    
  //  @Query("SELECT p FROM Post p WHERE p.tag_id = :tag_id")    
    //public List<Post> findByTag(@Param("tag_id") Long tag_id);
   // public Page<Post> findByDateIsTrueOrderByDateTimeDesc(Pageable pageable);
    @Query("SELECT p FROM Post p  ORDER BY p.date DESC")
    public Page<Post> findAll(Pageable pageable);


}
