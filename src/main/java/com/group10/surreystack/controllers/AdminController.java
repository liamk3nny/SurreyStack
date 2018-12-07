/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.DeleteCommentForm;
import com.group10.surreystack.forms.DeleteUserForm;
import com.group10.surreystack.services.CommentService;
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
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CommentService commentService;
    
    @RequestMapping(value = "/users/admin", method = RequestMethod.GET)
    public String register(DeleteUserForm deleteUserForm, DeleteCommentForm deleteCommentForm, Model model) {
        model.addAttribute("principal", getPrincipal());
        
        return "/users/admin";
    }
    
    @RequestMapping("/users/admin/deleteUser")
    public String deleteUser(@Valid DeleteUserForm deleteUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             return "/users/admin";
        }
        
        //commentService.deleteAllById()
        userService.deleteById(deleteUserForm.getUserId());
        
        return "redirect:/users/admin?deletedUser";
    }
    
    @RequestMapping("/users/admin/deleteComment")
    public String deleteComment(@Valid DeleteCommentForm deleteCommentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             return "/users/admin";
        }
        
        commentService.deleteById(deleteCommentForm.getCommentId());
        
        return "redirect:/users/admin?deletedComment";
    }
    
    //to delete user:
    //delete all of the comments with user_id's
    //delete all of the posts with user_id's 
    
    private String getPrincipal(){
        String userName = null;
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        
        return principal + " - " + principal2;
    }
    
}
