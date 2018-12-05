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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author aruns
 */
@Controller
public class HomeController {

    // Constructor based Dependency Injection
	private PostService postService;
        private TagService tagService;

	public HomeController() {

	}

	@Autowired
	public HomeController(PostService postService, TagService tagService) {
		this.postService = postService;
                this.tagService = tagService;
	}
  


    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String defaultURL(Model model) {

      List<Tag> alltags = tagService.findAll();
      model.addAttribute("alltags", alltags);
      
      model.addAttribute("principal", getPrincipal());

      List<Post> latest5Posts = postService.findAll();
      //  model.addAttribute("latest5posts", latest5Posts);

      List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
            model.addAttribute("latest5posts", latest3Posts);

        //model.addAttribute("latest3posts", latest3Posts);

        return "home";
    }
    
    private String getPrincipal(){
        String userName = null;
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        
        
        return principal;
    }


}
