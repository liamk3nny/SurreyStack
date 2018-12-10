
package com.group10.surreystack.controllers;


import com.group10.surreystack.forms.LoginForm;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * This controller handles the logging in of a user.
 * 
 * @author aruns
 */

@Controller
public class LoginController {

    /**
     * This method returns the view for the login page.
     * @param loginForm
     * @return 
     */
    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }
   

    /**
     * This method will check that all required fields are filled.
     * This validation occurs alongside spring security, which authenticates the
     * users details with those in the database.
     * The validation is checked by the LoginForm object. If it comes back without any errors,
     * the user will be redirected to the home page.
     * @param loginForm
     * @param bindingResult
     * @return 
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             return "users/login";
        }

        return "redirect:/home";
    }
    
    
    
}