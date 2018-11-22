/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Post;
import com.group10.surreystack.models.Tag;
import com.group10.surreystack.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamkenny
 */
@Service
public class TagServiceStubImpl implements TagService{
    
    private User user = new User(5L, "username1", "Ignas Kampas");
    private User user2 = new User(6L, "username2", "Liam Kenny");
    private User user3 = new User(5L, "username3", "Arun Subramanium");
    
    private List<Tag> tags = new ArrayList<Tag>() {{
        add(new Tag(11L, "Computer Science"));
        add(new Tag(12L, "Chemistry"));
        add(new Tag(13L, "Physics"));

    }};
    
    private List<Post> posts = new ArrayList<Post>(){{
        add(new Post(1L, "Help with Java", "<p>How do i initialise a variable</p>", user, tags.get(0)));
        add(new Post(2L, "How do you install Python?", "<p>I am having trouble installing python on my computer</p>", user2, tags.get(0)));
        add(new Post(3L, "Ionic bonding", "<p>Can someone please explain the difference between ionic and covalent bonding?</p>", user, tags.get(1)));
        add(new Post(4L, "What is a free redical?", "<p>I need help understanding what a free radical is</p>", user3, tags.get(1)));
        add(new Post(5L, "How much energy is too much?", "<p>What is 'too much' energy?</p>", user, tags.get(2)));
        add(new Post(6L, "What is the least dence metal?", "<p>What is the least dence metal alloy?</p>", user3, tags.get(2)));
    }};

    @Override
    public List<Tag> findAll() {
        return this.tags;
    }

    @Override
    public Tag findById(Long id) {
        return this.tags.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Tag create(Tag tag) {
        tag.setId(this.tags.stream().mapToLong(
                p -> p.getId()).max().getAsLong() + 1);
        this.tags.add(tag);
        return tag;
    }

    @Override
    public Tag edit(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
