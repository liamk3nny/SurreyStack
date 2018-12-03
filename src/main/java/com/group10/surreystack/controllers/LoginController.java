/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.dao.UserDAO;
import com.group10.surreystack.forms.LoginForm;
import com.group10.surreystack.models.User;
import com.group10.surreystack.services.NotificationService;
import com.group10.surreystack.services.UserService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author aruns
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;
    
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        
        return "users/login";
    }
   
   

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             notifyService.addErrorMessage("Please fill the form correctly!");
             return "users/login";
        }

        if (!userService.authenticate(
             loginForm.getUsername(), loginForm.getPassword())) {
             notifyService.addErrorMessage("Invalid login!");
             return "users/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/home";
    }
}