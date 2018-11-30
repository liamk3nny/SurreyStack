package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private PostService postService;
    
    // Temporary method until we find a way to store user's id in the application
    @RequestMapping("/users/profile")
    public String profile(Model model) {
        
        User user = profileService.findUserById(5L);
        
        String username = user.getUsername();
        model.addAttribute("username", username);
        
        String fullName = user.getFullName();   
        model.addAttribute("fullName", fullName);
        
        List<Post> userPosts = postService.findUserPosts(5L);
        model.addAttribute("userPosts", userPosts);
        
        return "users/profile";
    }
    
    @RequestMapping("/users/profile/{id}")
    public String profile(@PathVariable("id") Long id, Model model) {
        
        User user = profileService.findUserById(id);
        
        String username = user.getUsername();
        model.addAttribute("username", username);
        
        String fullName = user.getFullName();   
        model.addAttribute("fullName", fullName);
        
        List<Post> userPosts = postService.findUserPosts(id);
        model.addAttribute("userPosts", userPosts);
        
        return "users/profile";
    }
    
}
