/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This controller contains methods to display the top 10 most recent posts on the home page.
 * 
 * @author aruns
 */
@Controller
public class HomeController {

    
    private PostService postService;
    private TagService tagService;

    // Constructor based Dependency Injection
    public HomeController() {

    }
    
    @Autowired
    public HomeController(PostService postService, TagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }
  

    /**
     * This method displays the view for the home page using a GET method.
     * It retrieve the view and adds a list of all tags from the application to the list of tags on the side.
     * It gets the user information about the current user to show their username
     * in the top right hand corner of the header bar in the view.
     * It defines how many posts are shown per page.
     * @param model
     * @param page
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {

        
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        model.addAttribute("principal", getPrincipal());
        
        
        model.addAttribute("data", postService.
                findAll(PageRequest.of(page, 10)));
        model.addAttribute("currentPage",page);
        return "home";

    }

    /**
     * If a user is not logged in, this method will show an access denied page.
     * The main contents of the application should only be view by authenticated 
     * logged in users.
     * @param model
     * @return 
     */
    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDenied(Model model
    ) {
        return "access_denied";
    }

    /**
     * Gets the current users information, which is used to populate the header bar.
     * @return 
     */
    private String getPrincipal() {
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();

        return principal;

    }

}
