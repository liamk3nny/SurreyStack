/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller shows all posts under a certain tag.
 * @author liamkenny
 */
@Controller
public class TagController {

    TagService tagService;

    public TagController() {

    }

    @Autowired
    public TagController(PostService postService, TagService tagService) {
        this.tagService = tagService;
    }

    /**
     * This method displays all the posts which are linked to a certain tag using a GET method.
     * It retrieves the view and adds a list of all tags from the application to the list of tags on the side.
     * The data for this tag is retrieved from the database by using the TagService class.
     * This class has a method which allows a tag to be found by its id.
     * A set of posts are retrieved for this tag based on the tag id.
     * The information of this tag is then used to populate the view.
     * The posts are also added to the view.
     * The tag view is then returned. 
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = "/tags/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Tag tag = tagService.findById(id);
        model.addAttribute("tag", tag);
        Set<Post> post = tag.getPosts();
        model.addAttribute("post", sortPosts(post));
        model.addAttribute("principal", getPrincipal());
        if (post == null) {
            return "redirect:/home";
        }
        return "tags/view";
    }
    
    /**
     * Get the user information of the current user.
     * @return 
     */
    
    private String getPrincipal(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
     
    }
    
    /**
     * Method to sort the posts by most recent.
     * @param posts
     * @return 
     */
    private List<Post> sortPosts(Set<Post> posts){
        List<Post> postsList = new ArrayList<Post>();
        for(Post post : posts){
            postsList.add(post);
        }
        Collections.sort(postsList,(arg0,arg1)-> arg1.getDate().compareTo(arg0.getDate()));
        return postsList;
    }
}
