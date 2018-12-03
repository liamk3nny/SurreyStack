/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author liamkenny
 */
@Controller
public class TagController {
//    @Autowired
//    private TagService tagService;
//    
//    @Autowired PostService postService;
//    
//   
//      
//    @RequestMapping("/tags/view/{id}")
//    public String view(@PathVariable("id") Long id, Model model) {
//        Tag tag = tagService.findById(id);
//        model.addAttribute("tag", tag);
//        if (tag == null) {
//                return "redirect:/home";
//            }
//        
//      //  List<Post> posts = postService.findByTag(tag);
//        //model.addAttribute("posts", posts);
//        //if (posts == null) {
//          //      return "redirect:/home";
//           // }
//        return "tags/view";
//    }
}
