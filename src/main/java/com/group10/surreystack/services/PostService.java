/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author aruns
 */
public interface PostService {

    Page<Post> findAll(Pageable pageable);
    // List<Post> findLatest5();
    //Page<Post> findAllOrdered(Pageable pageable);

    Post findById(Long id);
    
    Long count();

    // List<Post> findUserPosts(Long userId);
 //   List<Post> findPostsByTag(Long tag_id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);

}
