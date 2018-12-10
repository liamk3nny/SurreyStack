/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This class creates a JPA repository for a Tag object, which helps find Tags
 * in the database
 *
 * @author aruns
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    /**
     * Method to find a tag in the database based on its name.
     *
     * @param tagName
     * @return
     */
    public Tag findByName(@Param("tagName") String tagName);

}
