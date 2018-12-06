/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.PostForm;
import com.group10.surreystack.forms.TagForm;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    public CreatePostController() {

    }

    @Autowired
    public CreatePostController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String createPost(Model model, TagForm tagForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        return "posts/createPost";
    }
    
    
    
    

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createTag(@Valid TagForm tagForm, BindingResult bindingResult, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        if (bindingResult.hasErrors()) {
             return "posts/create";
        }
        
        Tag t = new Tag();
        t.setName(tagForm.getTagName());
        tagService.create(t);
        
        return "posts/createPost";
    }

}
