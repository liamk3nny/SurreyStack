/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.DeleteUserForm;
import com.group10.surreystack.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ikamp
 */
@Controller
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/users/admin")
    public String register(DeleteUserForm deleteUserForm) {
        return "/users/admin";
    }
    
    @RequestMapping("/users/admin/deleteUser")
    public String deleteUser(@Valid DeleteUserForm deleteUserForm, BindingResult bindingResult) {
        
        
        
        if (bindingResult.hasErrors()) {
             return "/users/admin";
        }
        
        userService.deleteById(deleteUserForm.getUserId());
        
        return "redirect:/users/admin?deletedUser";
    }
    
    
}
