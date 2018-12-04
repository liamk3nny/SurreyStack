///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.group10.surreystack.services;
//
///**
// *
// * @author aruns
// */
//
//import com.group10.surreystack.models.Post;
//import com.group10.surreystack.models.Tag;
//import com.group10.surreystack.models.User;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
///**
// *
// * @author aruns
// */
//
//public class PostServiceStubImpl implements PostService {
//    
//
//    private User user = new User(5L, "username1", "Ignas Kampas");
//    private User user2 = new User(6L, "username2", "Liam Kenny");
//    private User user3 = new User(5L, "username3", "Arun Subramanium");
//    
//    private List<Tag> tags = new ArrayList<Tag>() {{
//        add(new Tag(11L, "Computer Science"));
//        add(new Tag(12L, "Chemistry"));
//        add(new Tag(13L, "Physics"));
//
//    }};
//    
//    private List<Post> posts = new ArrayList<Post>(){{
//        add(new Post(1L, "Help with Java", "<p>How do i initialise a variable</p>", user, tags.get(0)));
//        add(new Post(2L, "How do you install Python?", "<p>I am having trouble installing python on my computer</p>", user2, tags.get(0)));
//        add(new Post(3L, "Ionic bonding", "<p>Can someone please explain the difference between ionic and covalent bonding?</p>", user, tags.get(1)));
//        add(new Post(4L, "What is a free redical?", "<p>I need help understanding what a free radical is</p>", user3, tags.get(1)));
//        add(new Post(5L, "How much energy is too much?", "<p>What is 'too much' energy?</p>", user, tags.get(2)));
//        add(new Post(6L, "What is the least dence metal?", "<p>What is the least dence metal alloy?</p>", user3, tags.get(2)));
//    }};
//
//    
//    
//    @Override
//    public List<Post> findAll() {
//        return this.posts;
//    }
//
////    @Override
////    public List<Post> findLatest5() {
////        return this.posts.stream()
////                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
////                .limit(5)
////                .collect(Collectors.toList());
////    }
//
//    @Override
//    public Post findById(Long id) {
//        return this.posts.stream()
//                .filter(p -> Objects.equals(p.getPostID(), id))
//                .findFirst()
//                .orElse(null);
//    }
//    
////    @Override
////    public List<Post> findByTag(Tag tag) {
////        
////        return this.posts.stream()
////                .filter(p -> Objects.equals(p.getTag().getId(), tag.getId()))
////                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
////                .collect(Collectors.toList());
////    }
////    
////    @Override
////    public List<Post> findUserPosts(Long userId){
////        List<Post> userPosts = new ArrayList<Post>();
////        for (Post p : posts){
////            if(p.getUserId().equals(userId)){
////                userPosts.add(p);
////            }
////        }
//     //   return userPosts;
//    //}
//
//    @Override
//    public Post create(Post post) {
//        post.setPostID(this.posts.stream().mapToLong(
//                p -> p.getPostID()).max().getAsLong() + 1);
//        this.posts.add(post);
//        return post;
//    }
//
//    @Override
//    public Post edit(Post post) {
//        for (int i = 0; i < this.posts.size(); i++) {
//            if (Objects.equals(this.posts.get(i).getPostID(), post.getPostID())) {
//                this.posts.set(i, post);
//                return post;
//            }
//        }
//        throw new RuntimeException("Post not found: " + post.getPostID());
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        for (int i = 0; i < this.posts.size(); i++) {
//            if (Objects.equals(this.posts.get(i).getPostID(), id)) {
//                this.posts.remove(i);
//                return;
//            }
//        }
//        throw new RuntimeException("Post not found: " + id);
//    }
//
//    
//}
