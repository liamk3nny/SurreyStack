/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.services;

import com.group10.surreystack.models.Tag;
import java.util.List;

/**
 *
 * @author liamkenny
 */
public interface TagService {

    List<Tag> findAll();

    Tag findById(Long id);

    Tag create(Tag tag);

    Tag findByName(String tagName);

    void deleteById(Long id);

}
