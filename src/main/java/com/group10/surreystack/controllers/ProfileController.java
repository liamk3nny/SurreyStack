package com.group10.surreystack.controllers;

import com.group10.surreystack.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;
    
    @RequestMapping("/users/profile")
    public String profile(Model model) {
        
        String username = profileService.getUsername();
        model.addAttribute("username", username);
        
        String fullName = profileService.getFullName();
        model.addAttribute("fullName", fullName);
        
        return "users/profile";
    }
}
