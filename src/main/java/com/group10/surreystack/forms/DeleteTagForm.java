/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;

/**
 * This class gets the id of the tag being deleted.
 * @author ikamp
 */
public class DeleteTagForm {
    
    @NotNull
    private Long tagId;
    
    public Long getTagId(){
        return this.tagId;
    }
    
    public void setTagId(Long tagId){
        this.tagId = tagId;
    }
    
}
