/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author maddi
 */
@Service
public class CommentServiceStubImpl implements CommentService{
        
    List<Comment> comments = new ArrayList<Comment>() {{
        add(new Comment(1L, "This is a comment", new User(20L, "madfro", "Maddie Frost"), 1L));
    }};
    
    @Override
    public List<Comment> findComments(Long id) {
        List<Comment> postComments = new ArrayList<Comment>();
        for (Comment c : comments) {
            if(c.getPostId().equals(id)) {
                postComments.add(c);
            }
        }
        return postComments;
    }
}
