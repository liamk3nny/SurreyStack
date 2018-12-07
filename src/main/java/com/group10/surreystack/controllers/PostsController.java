/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.CommentForm;
import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.CommentService;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import com.group10.surreystack.services.UserDetailsImpl;
import com.group10.surreystack.services.UserService;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private TagService tagService;
    private CommentService commentService;
    private UserService userService;
    private UserDetailsImpl userDetails;

    public PostsController() {

    }

    @Autowired
    public PostsController(PostService postService, TagService tagService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.tagService = tagService;
        this.commentService = commentService;
        this.userService = userService;

    }

    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model, CommentForm commentForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Post post = postService.findById(id);
        Set<Comment> postComments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("postComments", postComments);
        if (post == null) {
            return "redirect:/home";
        }
        return "posts/view";
    }
    
    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.POST)
    public String postComment(@PathVariable("id") Long id, @Valid CommentForm commentForm, BindingResult bindingResult, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Post post = postService.findById(id);
        Set<Comment> postComments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("postComments", postComments);
        
        if (bindingResult.hasErrors()) {
             return "posts/view";
        }
        
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        
        Comment c = new Comment();
        c.setBody(commentForm.getCommentBody());        
        c.setUser(userService.findByUsername(principal));
        c.setPost(post);
        Date date = new Date();
        c.setDate(date);
        commentService.create(c);
        
        return "redirect:/posts/view/{id}";
    }
}
