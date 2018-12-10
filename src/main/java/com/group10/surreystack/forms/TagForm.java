/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class retrieves the information for a new tag being created.
 * If the name is empty, an error message will be displayed.
 * @author maddie
 */
public class TagForm {
    
    @NotEmpty(message="Tag name must not be blank")
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
}
