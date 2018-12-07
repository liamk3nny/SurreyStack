/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 *
 * @author maddie
 */
public interface CommentService {
   // List<Comment> findByPost_ID($Parameter(name="id")Long post_id);
    Comment create(Comment comment);
    
    void deleteById(Long id);
    
    //@Transactional
    //@Modifying
    //void deleteAllByPostId(Long id);
}
