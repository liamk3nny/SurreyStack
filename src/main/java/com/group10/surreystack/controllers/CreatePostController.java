/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author maddie
 */
@Controller
public class CreatePostController {
    
    @RequestMapping(value="/posts/create", method=RequestMethod.GET)
    public String createPost(){
        return "posts/createPost";
    }
    
    
    
}
