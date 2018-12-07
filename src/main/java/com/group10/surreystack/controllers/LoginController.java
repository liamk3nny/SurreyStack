
package com.group10.surreystack.controllers;


import com.group10.surreystack.forms.LoginForm;
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

    
    
    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }
   

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             return "users/login";
        }

        return "redirect:/home";
    }
    
    
    
}