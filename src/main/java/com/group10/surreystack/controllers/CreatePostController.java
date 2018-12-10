/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.controllers;

import com.group10.surreystack.forms.PostForm;
import com.group10.surreystack.forms.TagForm;
import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.services.PostService;
import com.group10.surreystack.services.TagService;
import com.group10.surreystack.services.UserService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller contains methods to handle the creation of a post and a tag.
 *
 * @author maddie
 */
@Controller
public class CreatePostController {

    private TagService tagService;
    private PostService postService;
    private UserService userService;

    public CreatePostController() {

    }

    @Autowired
    public CreatePostController(TagService tagService, PostService postService, UserService userService) {
        this.tagService = tagService;
        this.postService = postService;
        this.userService = userService;
    }

    /**
     * This method displays the view for the create post page using a GET
     * method. It retrieves the view and adds a list of all tags from the
     * application to the list of tags on the side.
     *
     * @param model
     * @param tagForm
     * @param postForm
     * @return
     */
    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String createPost(Model model, TagForm tagForm, PostForm postForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        return "posts/createPost";
    }

    /**
     * This method displays the create post view after a tag has been created
     * using a GET method. 
     * It retrieves the view and adds a list of all tags
     * from the application to the list of tags on the side.
     *
     * @param model
     * @param tagForm
     * @param postForm
     * @return
     */
    @RequestMapping(value = "/posts/createTag", method = RequestMethod.GET)
    public String createTag(Model model, TagForm tagForm, PostForm postForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);

        model.addAttribute("principal", getPrincipal());

        return "posts/createPost";
    }

    /**
     * This method handles the creation of a post. A POST method is used to pass
     * the new post object via hibernate which is then saved in the database.
     * The new post object is created by retrieving the results form the
     * PostForm object. Once created, the create post view is returned.
     *
     * @param postForm
     * @param bindingResult
     * @param model
     * @param tagForm
     * @return
     */
    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(@Valid PostForm postForm, BindingResult bindingResult, Model model, TagForm tagForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        model.addAttribute("principal", getPrincipal());

        Tag tag = tagService.findByName(postForm.getTagName());
        if (tag == null) {
            bindingResult.rejectValue("tagName", "error.tag", "Tag name does not exists");
        }

        if (bindingResult.hasErrors()) {
            return "posts/createPost";
        }

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        Date date = new Date();

        Post p = new Post();
        p.setTag(tagService.findByName(postForm.getTagName()));
        p.setTitle(postForm.getPostTitle());
        p.setBody(postForm.getPostBody());
        p.setUser(userService.findByUsername(principal));
        p.setDate(date);
        postService.create(p);

        return "posts/createPost";
    }

    /**
     * This method handles the creation of a tag. A POST method is used to pass
     * the new tag object via hibernate which is then saved in the database. 
     * The new tag object is created by retrieving the results form the PostForm
     * object, which has an attribute tag_name. 
     * Once created, the create post view is returned.
     *
     * @param tagForm
     * @param bindingResult
     * @param model
     * @param postForm
     * @return
     */
    @RequestMapping(value = "/posts/createTag", method = RequestMethod.POST)
    public String createTag(@Valid TagForm tagForm, BindingResult bindingResult, Model model, PostForm postForm) {
        List<Tag> alltags = tagService.findAll();
        model.addAttribute("alltags", alltags);
        model.addAttribute("principal", getPrincipal());

        Tag tag = tagService.findByName(tagForm.getTagName());
        if (tag != null) {
            bindingResult.rejectValue("tagName", "error.tag", "Tag name already exists");
        }

        if (bindingResult.hasErrors()) {
            return "posts/createPost";
        }

        Tag t = new Tag();
        t.setName(tagForm.getTagName());
        tagService.create(t);
        return "posts/createPost";
    }

    /**
     * Gets the current users information, which is used to create the post
     * object in the database. 
     * A post must have a user in order to be created.
     *
     * @return
     */
    private String getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
