/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface for PostServiceJpaImpl
 *
 * @author aruns
 */
public interface PostService {

    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    Long count();

    Post create(Post post);

    Post edit(Post post);

    void deleteById(Long id);

}
