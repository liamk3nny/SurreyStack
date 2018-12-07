package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.ProfileForm;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
    
    @Autowired
    private UserService userService;
    
    
    
    @RequestMapping(value="/users/profile", method = RequestMethod.GET)
    public String profile(Model model, ProfileForm profileForm) {
        User user = userService.findByUsername(getPrincipal());
        
        
        
        
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("principal", user.getUsername());
        model.addAttribute("posts", sortPosts(user.getPosts()));
       
        
        return "users/profile";
    }
    
    
    @RequestMapping(value = "/users/profile", method = RequestMethod.POST)
    public String updatePassword(Model model, @Valid ProfileForm profileForm, BindingResult bindingResult) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
        User user = userService.findByUsername(getPrincipal());
        
        if(!passwordEncoder.matches(profileForm.getPrev_password(), user.getPassword())){
            return "redirect:/users/profile?error";
        }
        
        
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("principal", user.getUsername());
        model.addAttribute("posts", sortPosts(user.getPosts()));
        
        
        if (bindingResult.hasErrors()) {
            return "/users/profile";
        }
        
      
        user.setPassword(passwordEncoder.encode(profileForm.getPassword()));
        userService.save(user);
        
        
        return "redirect:/users/profile?updated";
    }

    
    private String getPrincipal(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
     
    }
    
    private List<Post> sortPosts(Set<Post> posts){
        List<Post> postsList = new ArrayList<Post>();
        for(Post post : posts){
            postsList.add(post);
        }
        Collections.sort(postsList,(arg0,arg1)-> arg1.getDate().compareTo(arg0.getDate()));
        return postsList;
    }

  
    
    
}
