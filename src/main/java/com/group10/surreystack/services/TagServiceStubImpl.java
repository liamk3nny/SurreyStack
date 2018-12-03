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

public class TagServiceStubImpl implements TagService{
    
  
    
    private List<Tag> tags = new ArrayList<Tag>() {{
        add(new Tag(11L, "Computer Science"));
        add(new Tag(12L, "Chemistry"));
        add(new Tag(13L, "Physics"));

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

//    @Override
//    public Tag edit(Tag tag) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
    
}
