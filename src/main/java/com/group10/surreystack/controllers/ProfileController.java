package com.group10.surreystack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/users/profile")
    public String profile() {
        return "users/profile";
    }
}
