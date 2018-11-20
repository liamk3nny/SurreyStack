/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.services.NotificationService;
import com.group10.surreystack.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aruns
 */
@Controller
public class PostsController {
    @Autowired
    private PostService postService;
    
    @Autowired
    private NotificationService notifyService;
      
    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        if (post == null) {
                notifyService.addErrorMessage("Cannot find post #" + id);
                return "redirect:/home";
            }
        return "posts/view";
    }

}
