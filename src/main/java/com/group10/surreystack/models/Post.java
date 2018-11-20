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
public class Post {
private Long id;
private String title;
private String body;
private User author;
private Tag tag;
private Date date = new Date();

    public Post(Long id, String title, String body, User author, Tag tag) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.tag = tag;
    }

    public Post() {
    }

    public Long getId() {
        return id;
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

    public Tag getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Post{" + "id=" + id + ", title=" + title + ", body=" + body + ", author=" + author + ", tag=" + tag + ", date=" + date + '}';
    }
    
}
