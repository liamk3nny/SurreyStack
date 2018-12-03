/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author maddie
 */
public interface CommentService {
    List<Comment> findComments(Long id);
}
