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
import javax.activation.DataSource;
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
    
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate( (javax.sql.DataSource) dataSource);
    }

    @Override
    public void saveOrUpdate(User user) {
        if(user.getId() > 0){
            String sql = "UPDATE user SET name=?, username=? WHERE user_id=?";
            jdbcTemplate.update(sql, user.getFullName(), user.getUsername());
        }else{
            String sql = "INSET into user (name, username) VALUES (?, ?)";
            jdbcTemplate.update(sql, user.getFullName(), user.getUsername());
        }
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE user WHERE user_id=?";
        jdbcTemplate.update(sql, user.getId());
    }

    @Override
    public User getUser(int userID) {
        String sql = "SELECT * FROM user WHERE user_id=" + userID;
        return jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                User user = new User();
                user.setFullName("name");
                user.setUsername("username");
                return user;
            }
            return null;
        });
        
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                
                user.setId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                
                return user;
            }
        });
        
        return users;
    }
    
}
