/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.LoginForm;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;

import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aruns
 */
@Controller
public class HomeController {
  
    @Autowired
    private PostService postService;
    
    @Autowired
    private TagService tagService;
    
    

    @RequestMapping(value = "/")
    public String defaultURL(Model model) {
      
                
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        
        
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
       

        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        
        return "home";
    }
    
    @RequestMapping(value = "/home")
    public String index(Model model) {
        
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
       

        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        
        return "home";

    }
}
