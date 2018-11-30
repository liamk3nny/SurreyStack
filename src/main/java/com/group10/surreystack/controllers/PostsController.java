/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.CommentForm;
import com.group10.surreystack.models.Comment;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.services.CommentService;
import com.group10.surreystack.services.PostService;
import java.util.List;
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
    private CommentService commentService;
    

      
    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model, CommentForm commentForm) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        List<Comment> postComments = commentService.findComments(id);
        model.addAttribute("postComments", postComments);
        if (post == null) {
                return "redirect:/home";
            }
        return "posts/view";
    }
    
//    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.POST)
//    public String addComment(@Valid CommentForm commentForm, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            notifyService.addErrorMessage("Please leave a correct comment");
//            return "posts/view";
//        }
//        notifyService.addInfoMessage("Comment posted");
//        return "posts/view";
//    }
    

}
