/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group10.surreystack.repositories.PostRepository;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class implements the Jpa methods which find, count, create, edit and
 * delete posts.
 *
 * @author aruns
 */
@Service
@Transactional
public class PostServiceJpaImpl implements PostService {

    // Implementing Constructor based DI
    private PostRepository postRepo;

    public PostServiceJpaImpl() {

    }

    @Autowired
    public PostServiceJpaImpl(PostRepository postRepo) {
        super();
        this.postRepo = postRepo;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        Page<Post> postList = this.postRepo.findAll(pageable);
        return postList;
    }

    public Long count() {
        return this.postRepo.count();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepo.getOne(id);
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.deleteById(id);
    }

}
