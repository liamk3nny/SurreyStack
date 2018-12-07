package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    
    @Autowired
    private UserService userService;
    
    
    
    @RequestMapping("/users/profile")
    public String profile(Model model) {
        User user = userService.findByUsername(getPrincipal());
        
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("principal", user.getUsername());
        model.addAttribute("posts", user.getPosts());
       
        
        return "users/profile";
    }
    
    private String getPrincipal(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
     
    }
}
