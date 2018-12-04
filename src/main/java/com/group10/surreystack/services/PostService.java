/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;

import java.util.List;

/**
 *
 * @author aruns
 */
public interface PostService {

    List<Post> findAll();
    // List<Post> findLatest5();

    Post findById(Long id);

    // List<Post> findUserPosts(Long userId);
 //   List<Post> findPostsByTag(Long tag_id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);

}
