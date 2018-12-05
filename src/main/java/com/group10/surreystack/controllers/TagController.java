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
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
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

    @RequestMapping(value = "/tags/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        Tag tag = tagService.findById(id);
        model.addAttribute("tag", tag);
        Set<Post> post = tag.getPosts();
        model.addAttribute("post", post);
        if (post == null) {
            return "redirect:/home";
        }
        return "tags/view";
    }
}
