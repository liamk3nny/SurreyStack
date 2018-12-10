package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.ProfileForm;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.User;
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

/**
 * This controller retrieves all posts made by a user and allows them to update 
 * the password to their account.
 * @author liamkenny
 */
@Controller
public class ProfileController {
    
    @Autowired
    private UserService userService;
    
    
    /**
     * This method get the information of the current user and populates the view using a GET method.
     * The profile view is returned.
     * @param model
     * @param profileForm
     * @return 
     */
    @RequestMapping(value="/users/profile", method = RequestMethod.GET)
    public String profile(Model model, ProfileForm profileForm) {
        User user = userService.findByUsername(getPrincipal());
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("principal", user.getUsername());
        model.addAttribute("posts", sortPosts(user.getPosts()));
       
        return "users/profile";
    }
    
    /**
     * This method allows a user to update their password using a POST method.
     * It populates the view with the user information and their posts.
     * If a user enters a password which matches their current password, an error
     * message is displayed.
     * Otherwise, the users password is updated and saved as a salted hash in the database.
     * @param model
     * @param profileForm
     * @param bindingResult
     * @return 
     */
    @RequestMapping(value = "/users/profile", method = RequestMethod.POST)
    public String updatePassword(Model model, @Valid ProfileForm profileForm, BindingResult bindingResult) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
        User user = userService.findByUsername(getPrincipal());
    
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("principal", user.getUsername());
        model.addAttribute("posts", sortPosts(user.getPosts()));
        
        if (bindingResult.hasErrors()) {
            return "/users/profile";
        }
        if(!passwordEncoder.matches(profileForm.getPrev_password(), user.getPassword())){
            return "redirect:/users/profile?error";
        }
      
        user.setPassword(passwordEncoder.encode(profileForm.getPassword()));
        userService.save(user);
        
        
        return "redirect:/users/profile?updated";
    }

    /**
     * Gets the user information of the current user.
     * @return 
     */
    private String getPrincipal(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
     
    }
    
    /**
     * Method to sort the posts by most recent
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