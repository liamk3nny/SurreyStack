/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.DeleteCommentForm;
import com.group10.surreystack.forms.DeletePostForm;
import com.group10.surreystack.forms.DeleteTagForm;
import com.group10.surreystack.forms.DeleteUserForm;
import com.group10.surreystack.services.CommentService;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import com.group10.surreystack.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ikamp
 */
@Controller
public class AdminController {


    private CommentService commentService;
    private TagService tagService;
    private PostService postService;
    private UserService userService;
    
    public AdminController(){
        
    }
    
    @Autowired
    public AdminController(CommentService commentService, TagService tagService, PostService postService, UserService userService){
        this.commentService = commentService;
        this.tagService = tagService;
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/users/admin/**", method = RequestMethod.GET)
    public String register(DeleteUserForm deleteUserForm, DeletePostForm deletePostForm, DeleteTagForm deleteTagForm, DeleteCommentForm deleteCommentForm, Model model) {
        model.addAttribute("principal", getPrincipal());

        return "/users/admin";
    }

    @RequestMapping(value="/users/admin/deleteUser")
    public String deleteUser(@Valid DeleteUserForm deleteUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }
        try{
            userService.deleteById(deleteUserForm.getUserId());
        }catch(Exception e){
            return "redirect:/users/admin?user_error";
        }
        

        return "redirect:/users/admin?deletedUser";
    }

    @RequestMapping(value="/users/admin/deleteTag")
    public String deleteTag(@Valid DeleteTagForm deleteTagForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }
        try{
            tagService.deleteById(deleteTagForm.getTagId());
        }catch(Exception e){
            return "redirect:/users/admin?tag_error";
        }
        

        return "redirect:/users/admin?deletedTag";
    }

    @RequestMapping(value="/users/admin/deletePost")
    public String deletePost(@Valid DeletePostForm deletePostForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }
        try{
           postService.deleteById(deletePostForm.getPostId()); 
        }catch(Exception e){
            return "redirect:/users/admin?post_error";
        }
        

        return "redirect:/users/admin?deletedPost";
    }

    @RequestMapping(value="/users/admin/deleteComment")
    public String deleteComment(@Valid DeleteCommentForm deleteCommentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }
        try{
            commentService.deleteById(deleteCommentForm.getCommentId());
        }catch(Exception e){
            return "redirect:/users/admin?comment_error";
        }
        

        return "redirect:/users/admin?deletedComment";
    }

    private String getPrincipal() {
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        return principal + " - " + principal2;
    }

}
