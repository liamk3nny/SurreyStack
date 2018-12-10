/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class retrieves the information for a new post being created.
 * If the title, body or tag is empty, an error message will be displayed.
 * @author maddie
 */
public class PostForm {

    @NotEmpty(message = "Title must not be empty")
    private String postTitle;

    @NotEmpty(message = "Body must not be empty")
    private String postBody;

    @NotEmpty(message = "Tag must not be empty")
    private String tagName;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
