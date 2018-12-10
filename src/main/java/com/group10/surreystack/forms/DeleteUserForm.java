/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import javax.validation.constraints.NotNull;

/**
 * This class gets the id of the user being deleted.
 * @author ikamp
 */
public class DeleteUserForm {
    
    @NotNull
    private Long userId;
    
    public Long getUserId(){
        return this.userId;
    }
    
    public void setUserId(Long userId){
        this.userId = userId;
    }
}
