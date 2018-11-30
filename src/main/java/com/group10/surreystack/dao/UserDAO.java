/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.dao;

import com.group10.surreystack.models.User;
import java.util.List;

/**
 *
 * @author liamkenny
 */
public interface UserDAO {
    
    public void saveOrUpdate(User contact);
	
	public void delete(int contactId);
	
	public User get(int contactId);
	
	public List<User> list();
    
}
