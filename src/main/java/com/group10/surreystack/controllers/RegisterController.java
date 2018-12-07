/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.RegisterForm;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.models.Role;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author aruns
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/users/register", method = RequestMethod.GET)
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    
    
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
