package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private PostService postService;
    
    @RequestMapping("/users/profile")
    public String profile(Model model) {
        
        String username = profileService.getUsername();
        model.addAttribute("username", username);
        
        String fullName = profileService.getFullName();
        model.addAttribute("fullName", fullName);
        
        List<Post> userPosts = postService.findUserPosts(profileService.getUserId());
        model.addAttribute("userPosts", userPosts);
        
        return "users/profile";
    }
}