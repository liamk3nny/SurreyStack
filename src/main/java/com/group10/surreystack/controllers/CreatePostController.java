/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.PostForm;
import com.group10.surreystack.forms.TagForm;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import com.group10.surreystack.services.UserService;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author maddie
 */
@Controller
public class CreatePostController {

    private TagService tagService;
    private PostService postService;
    private UserService userService;

    public CreatePostController() {

    }

    @Autowired
    public CreatePostController(TagService tagService, PostService postService, UserService userService) {
        this.tagService = tagService;
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String createPost(Model model, TagForm tagForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        return "posts/createPost";
    }

    @RequestMapping(value = "/posts/createTag", method = RequestMethod.GET)
    public String createTag(Model model, TagForm tagForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        return "posts/createPost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(@Valid PostForm postForm, BindingResult bindingResult, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        if (bindingResult.hasErrors()) {
            return "posts/create";
        }

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        Date date = new Date();

        Post p = new Post();
        p.setTag(tagService.findByName(postForm.getTagName()));
        p.setTitle(postForm.getPostTitle());
        p.setBody(postForm.getPostBody());
        p.setUser(userService.findByUsername(principal));
        p.setDate(date);
        postService.create(p);

        return "posts/createPost";
    }

    @RequestMapping(value = "/posts/createTag", method = RequestMethod.POST)
    public String createTag(@Valid TagForm tagForm, BindingResult bindingResult, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Tag tag = tagService.findByName(tagForm.getTagName());
        if(tag != null){
            bindingResult.rejectValue("tagName", "error.tag", "Tag name already exists");
        }
        
        if (bindingResult.hasErrors()) {
            return "posts/createPost";
        }

        Tag t = new Tag();
        t.setName(tagForm.getTagName());
        tagService.create(t);
        return "posts/createPost";
    }

}
