/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Tag;
import com.group10.surreystack.repositories.TagRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aruns
 */
@Service
@Transactional
public class TagServiceJpaImpl implements TagService{

    private TagRepository tagRepo;

    public TagServiceJpaImpl() {

    }

    @Autowired
    public TagServiceJpaImpl(TagRepository tagRepo) {
        super();
        this.tagRepo = tagRepo;
    }

    @Override
    public List<Tag> findAll() {
        return this.tagRepo.findAll();

    }

    @Override
    public Tag findById(Long id) {
        return this.tagRepo.getOne(id);

    }

    @Override
    public Tag create(Tag tag) {
        return this.tagRepo.save(tag);
    }
    
    @Override
    public Tag findByName(String tagName){
        return this.tagRepo.findByName(tagName);
    }

    @Override
    public void deleteById(Long id){
        this.tagRepo.deleteById(id);
    }

}
