/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Comment;
import java.util.List;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aruns
 */@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
     
   // @Query("SELECT c FROM Comment c WHERE c.post_id = :post_id")    
    //public List<Comment> findComments(@Param("post_id") Long post_id);
     
      //   List<Comment> findByPost_Id(@Parameter(name="id")Long post_id);


}
