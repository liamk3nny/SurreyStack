/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.RegisterForm;
import com.group10.surreystack.models.Role;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handles the registration of a new user to the system.
 * @author aruns
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    
    /**
     * This method returns the register view.
     * @param registerForm
     * @return 
     */
    @RequestMapping(value="/users/register", method = RequestMethod.GET)
    public String register(RegisterForm registerForm) {
        return "users/register";
    }
    
    /**
     * This method registers a new user to the system.
     * If any parts of the form have not been filled in, an error message will be shown.
     * Otherwise, the users password is encrypted with a salted hash.
     * The users role is set to user.
     * A new user object is created and populated with the values from the RegisterForm object.
     * This user object is saved to the database.
     * @param registerForm
     * @param bindingResult
     * @return 
     */
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String RegisterPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        User user = userService.findByUsername(registerForm.getUsername());
        if (user != null) {
            bindingResult.rejectValue("username", "error.user", "Username already taken");
        }

        if (bindingResult.hasErrors()) {
             return "/users/register";
        }
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role userRole = new Role();
        userRole.setRole_id(2L);
        
        User u = new User();
        u.setUsername(registerForm.getUsername());
        u.setFullName(registerForm.getName());
        u.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        u.setRole(userRole);
        
        userService.create(u);
                
        return "redirect:/users/login?registered";


    }
}
