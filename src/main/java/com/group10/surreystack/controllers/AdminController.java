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

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/admin", method = RequestMethod.GET)
    public String register(DeleteUserForm deleteUserForm, DeletePostForm deletePostForm, DeleteTagForm deleteTagForm, DeleteCommentForm deleteCommentForm, Model model) {
        model.addAttribute("principal", getPrincipal());

        return "/users/admin";
    }

    @RequestMapping("/users/admin/deleteUser")
    public String deleteUser(@Valid DeleteUserForm deleteUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }

        userService.deleteById(deleteUserForm.getUserId());

        return "redirect:/users/admin";
    }

    @RequestMapping("/users/admin/deleteTag")
    public String deleteTag(@Valid DeleteTagForm deleteTagForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }

        tagService.deleteById(deleteTagForm.getTagId());

        return "redirect:/users/admin";
    }

    @RequestMapping("/users/admin/deletePost")
    public String deletePost(@Valid DeletePostForm deletePostForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }

        postService.deleteById(deletePostForm.getPostId());

        return "redirect:/users/admin";
    }

    @RequestMapping("/users/admin/deleteComment")
    public String deleteComment(@Valid DeleteCommentForm deleteCommentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin";
        }

        commentService.deleteById(deleteCommentForm.getCommentId());

        return "redirect:/users/admin";
    }

    private String getPrincipal() {
        String userName = null;
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        return principal + " - " + principal2;
    }

}
