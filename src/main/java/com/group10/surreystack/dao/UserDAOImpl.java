/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.dao;

import com.group10.surreystack.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author liamkenny
 */
public class UserDAOImpl implements UserDAO{
    
    private JdbcTemplate jdbcTemplate;
    
    public UserDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(User user) {
        if(user.getId() > 0){
            String sql = "UPDATE user SET name=?, username=?, password=?";
            jdbcTemplate.update(sql, user.getFullName(), user.getUsername(), user.getPasswordHash());
        }else{
            String sql = "INSERT into tblUser (name, username, password) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, user.getFullName(), user.getUsername(), user.getPasswordHash());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELECT FROM tblUser WHERE user_id=?";
        jdbcTemplate.update(sql, id);        
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM tblUser WHERE user_id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>(){
            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    User user = new User();
                    user.setId(0L);
                    user.setFullName("name");
                    user.setUsername("username");
                    user.setPasswordHash("password");
                    
                    return user;
                }
                return null;
            }
            
        });
        
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM tblUser";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException{
                User myUser = new User();
                
                myUser.setId(0L);
                myUser.setFullName("name");
                myUser.setUsername("username");
                myUser.setPasswordHash("password");
                
                return myUser;
            }
			
        });
        return userList;
    }
    
}
