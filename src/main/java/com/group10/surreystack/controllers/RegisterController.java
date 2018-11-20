/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.RegisterForm;
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
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;
    
    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String RegisterPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             notifyService.addErrorMessage("Please fill the form correctly!");
             return "users/register";
        }

        if (!userService.authenticate(
             registerForm.getUsername(), registerForm.getPassword())) {
             notifyService.addErrorMessage("Invalid Registration!");
             return "users/register";
        }

        notifyService.addInfoMessage("Registration successful");
        return "redirect:/users/login";
    }
}
