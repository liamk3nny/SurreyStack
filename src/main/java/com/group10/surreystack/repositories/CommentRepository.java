/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.repositories;

import com.group10.surreystack.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This class creates a JPA repository for a Comment object, which helps find Comments 
 * in the database
 * 
 * @author aruns
 */@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
     
}
