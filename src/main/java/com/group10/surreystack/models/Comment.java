/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.models;

import java.util.Date;

/**
 *
 * @author aruns
 */
public class Comment {
    private Long id;
    private String body;
    private User author;
    private Long postId;
    private Date date = new Date();

    public Comment(Long id, String body, User author, Long postId) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }

    public Long getPostId() {
        return postId;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setPost(Long postId) {
        this.postId = postId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
