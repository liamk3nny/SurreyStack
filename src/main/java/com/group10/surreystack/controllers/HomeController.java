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
import java.util.LinkedHashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {

        
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        model.addAttribute("principal", getPrincipal());
        
        
        model.addAttribute("data", postService.
                findAll(PageRequest.of(page, 5)));
        model.addAttribute("currentPage",page);
        return "home";

    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDenied(Model model
    ) {
        return "access_denied";
    }

    private String getPrincipal() {
        String userName = null;
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        return principal + " - " + principal2;
    }

}
