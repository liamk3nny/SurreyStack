/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.group10.surreystack.repositories.PostRepository;
import javax.transaction.Transactional;

/**
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
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

  //  @Override
//    public List<Post> findLatest5() {
   //     return this.postRepo.findLatest5Posts()(new PageRequest(0, 5));
    //}

//    @Override
//    public List<Post> findUserPosts(Long userId) {
//        return this.postRepo.findAll();
//    }
//

    
    
    
    
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

    @Override
    public List<Post> findByTag(Long tagId) {
        return this.postRepo.findByTag(tagId);
    }
    
   
    

}
