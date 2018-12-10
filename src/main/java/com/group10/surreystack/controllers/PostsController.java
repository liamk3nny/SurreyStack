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
import com.group10.surreystack.services.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handles the display of a posts, as well as showing and creating comments.
 * @author aruns
 */
@Controller
public class PostsController {

    private PostService postService;
    private TagService tagService;
    private CommentService commentService;
    private UserService userService;

    public PostsController() {

    }

    @Autowired
    public PostsController(PostService postService, TagService tagService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.tagService = tagService;
        this.commentService = commentService;
        this.userService = userService;

    }

    /**
     * This method displays the contents of a specific post using a GET method
     * It retrieves the view and adds a list of all tags from the application to the list of tags on the side.
     * The data for this post is retrieved from the database by using the PostService class.
     * This class has a method which allows a post to be found by its id.
     * A set of comments are retrieved for this post based on the post id.
     * The information of this posts is then used to populate the view.
     * The comments are also added to the view.
     * The post view is then returned. 
     * @param id
     * @param model
     * @param commentForm
     * @return 
     */
    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model, CommentForm commentForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Post post = postService.findById(id);
        Set<Comment> postComments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("postComments", sortComments(postComments));
        model.addAttribute("principal", getPrincipal());
        if (post == null) {
            return "redirect:/home";
        }
        return "posts/view";
    }
    
    /**
     * This method allows the user to leave a comment on a post using a POST method.
     * It retrieves the view and adds a list of all tags from the application to the list of tags on the side.
     * The data for the post is retrieved in the same was as the previous method.
     * The user details of the current user are retrieved and stored in String principle.
     * A new comment object is created and populated with the results from the CommentForm object
     * This commentForm object validates that all fields have been filled in correctly by the user.
     * The comment is created and saved to the database
     * The post view is returned, and will now show the users comment.
     * If the comment form was not validated, an error message will now appear. 
     * @param id
     * @param commentForm
     * @param bindingResult
     * @param model
     * @return 
     */
    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.POST)
    public String postComment(@PathVariable("id") Long id, @Valid CommentForm commentForm, BindingResult bindingResult, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Post post = postService.findById(id);
        Set<Comment> postComments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("postComments", sortComments(postComments));
        
        if (bindingResult.hasErrors()) {
             return "redirect:/posts/view/{id}?error";
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
    
    /**
     * Gets the user information of the current user.
     * @return 
     */
    private String getPrincipal(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
     
    }
    
    /**
     * Method to sort the comments by date order.
     * @param comments
     * @return 
     */
    private List<Comment> sortComments(Set<Comment> comments){
        List<Comment> commentsList = new ArrayList<Comment>();
        for(Comment comment : comments){
            commentsList.add(comment);
        }
        Collections.sort(commentsList,(arg0,arg1)-> arg1.getDate().compareTo(arg0.getDate()));
        return commentsList;
    }
}
