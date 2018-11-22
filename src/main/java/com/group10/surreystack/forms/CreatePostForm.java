/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import com.group10.surreystack.models.Tag;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ikamp
 */
public class CreatePostForm {
    @Size(min=5, max=100, message = "Post title size should be in the range [5...30]")
    private String title;

    @NotNull
    @Size(min=1, max=20)
    private Tag tag;
    
    @NotNull
    @Size(min=1, max=10000)
    private String body;
 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
    
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
