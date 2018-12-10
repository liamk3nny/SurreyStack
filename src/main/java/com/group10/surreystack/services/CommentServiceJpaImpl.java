/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Comment;
import com.group10.surreystack.repositories.CommentRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class creates and deletes comments using the Jpa methods.
 * @author aruns
 */
@Service
@Transactional
public class CommentServiceJpaImpl implements CommentService {

    private CommentRepository commentRepo;

    public CommentServiceJpaImpl() {

    }

    @Autowired
    public CommentServiceJpaImpl(CommentRepository commentRepo) {
        super();
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment create(Comment comment) {
        return this.commentRepo.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        this.commentRepo.deleteById(id);
    }

}
