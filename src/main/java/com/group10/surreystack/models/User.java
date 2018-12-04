/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aruns
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(length = 100)
    private String fullName;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<Comment>();

    @Override
    public String toString() {
        return "User{" + "id=" + user_id + ", username=" + username + ", passwordHash=" + password + ", fullName=" + fullName + '}';
    }

    public User() {
    }

    public User(Long user_id, String username, String fullName) {
        this.user_id = user_id;
        this.username = username;
        this.fullName = fullName;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> comments) {
        this.posts = posts;
    }
    public Set<Comment> getcomments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
