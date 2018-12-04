/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Comment;
import com.group10.surreystack.repositories.CommentRepository;
import com.group10.surreystack.repositories.PostRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aruns
 */
@Service
@Transactional
public class CommentServiceJpaImpl {
    
    private CommentRepository commentRepo;

    public CommentServiceJpaImpl() {

    }

    @Autowired
    public CommentServiceJpaImpl(CommentRepository commentRepo) {
        super();
        this.commentRepo = commentRepo;
    }
    
//    @Override
//    public    List<Comment> findComments(Long id){
//        return this.commentRepo.findComments();
//    };

}