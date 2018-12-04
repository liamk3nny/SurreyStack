/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.CommentForm;
import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.services.CommentService;
import com.group10.surreystack.services.PostService;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author aruns
 */
@Controller
public class PostsController {

    private PostService postService;

    public PostsController() {

    }

    @Autowired
    public PostsController(PostService postService, CommentService commentService) {
        this.postService = postService;

    }

    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model, CommentForm commentForm) {
        Post post = postService.findById(id);
        Set<Comment> postComments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("postComments", postComments);
        if (post == null) {
            return "redirect:/home";
        }
        return "posts/view";
    }
}
