/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maddi
 */
public class CommentForm {
    
    @NotNull
    @Size(min=1, max=50)
    private String commentBody;

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    
    
    
}
