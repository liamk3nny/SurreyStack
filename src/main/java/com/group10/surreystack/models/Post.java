/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aruns
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;
         
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<Comment>();
    
    @Column(nullable = false)
    private Date date = new Date();
    
    public Post(){}
    
    
    public Post(Long post_id, String title, String body, User user, Tag tag) {
        this.post_id = post_id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.tag = tag;
    }


      public Long getPost_id() {
        return post_id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public Long getUserId() {
        return this.user.getUser_id();
    }

    public Tag getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }

    public Set<Comment> getComments() {
        return comments;
    }
    

    public void setPostId(Long post_id) {
        this.post_id = post_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + post_id + ", title=" + title + ", body=" + body + ", user=" + user + ", tag=" + tag + ", date=" + date + '}';
    }

}
