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
    private Long postID;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tag tag;
     @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<Comment>();
    @Column(nullable = false)
    private Date date = new Date();
    
    public Post(Long id, String title, String body, User author, Tag tag) {
        this.postID = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.tag = tag;
    }

    public Post() {
    }

    public Long getPostID() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }

    public Long getUserId() {
        return this.author.getId();
    }

    public Tag getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + postID + ", title=" + title + ", body=" + body + ", author=" + author + ", tag=" + tag + ", date=" + date + '}';
    }

}
