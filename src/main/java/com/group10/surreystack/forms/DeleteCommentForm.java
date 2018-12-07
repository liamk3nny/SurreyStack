/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;

/**
 *
 * @author ikamp
 */
public class DeleteCommentForm {
    
    @NotNull
    private Long commentId;
    
    public Long getCommentId(){
        return this.commentId;
    }
    
    public void setCommentId(Long commentId){
        this.commentId = commentId;
    }
    
}
