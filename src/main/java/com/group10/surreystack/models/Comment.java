/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class creates a comment for a post
 * 
 * @author aruns
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    @Column(nullable = false)
    private Date date = new Date();

    public Comment(){}
    
    public Comment(Long comment_id, String body, User user, Post post) {
        this.comment_id = comment_id;
        this.body = body;
        this.user = user;
        this.post = post;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }
  

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
