/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;

/**
 * This class gets the id of the post being deleted.
 * @author ikamp
 */
public class DeletePostForm {
    
    @NotNull
    private Long postId;
    
    public Long getPostId(){
        return this.postId;
    }
    
    public void setPostId(Long postId){
        this.postId = postId;
    }
    
}
