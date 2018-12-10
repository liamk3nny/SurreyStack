/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class retrieves the information for a new comment being created.
 * If the comment is empty, an error message will be displayed.
 * @author maddie
 */
public class CommentForm {
    
    @NotEmpty(message = "Please enter a comment")
    private String commentBody;

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    
    
    
}
