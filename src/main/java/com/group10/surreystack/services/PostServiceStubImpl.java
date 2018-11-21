/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

/**
 *
 * @author aruns
 */

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.models.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author aruns
 */
@Service
public class PostServiceStubImpl implements PostService {
    
    private User user = new User(5L, "username1", "Ignas Kampas");
    
    private List<Post> posts = new ArrayList<Post>() {{
        add(new Post(1L, "First Post", "<p>body.</p><p>Line #2</p>", user, null));
        add(new Post(2L, "Second Post","Second post content:<ul><li>line 1</li><li>line 2</li></p>", new User(10L, "pesho10", "Peter Ivanov"),new Tag(10L,"CS")));
        add(new Post(3L, "Post #3", "<p>The post number 3 nice</p>", new User(10L, "merry", null), new Tag(2L,"maths")));
        add(new Post(4L, "Post #4", "This is post 4 body", user, null));
    }};

    
    
    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public List<Post> findLatest5() {
        return this.posts.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Post> findUserPosts(Long userId){
        List<Post> userPosts = new ArrayList<Post>();
        for (Post p : posts){
            if(p.getUserId().equals(userId)){
                userPosts.add(p);
            }
        }
        return userPosts;
    }

    @Override
    public Post create(Post post) {
        post.setId(this.posts.stream().mapToLong(
                p -> p.getId()).max().getAsLong() + 1);
        this.posts.add(post);
        return post;
    }

    @Override
    public Post edit(Post post) {
        for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found: " + post.getId());
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), id)) {
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }
}
