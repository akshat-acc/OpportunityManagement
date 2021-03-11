package com.accolite.opportunitymanagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.opportunitymanagement.mapper.UserMapper;
import com.accolite.opportunitymanagement.model.User;

@Repository("UserService")
@Transactional
public class UserServiceImpl {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public int insert(User user) {
        String insertSQL = "insert into User (firstName,lastName,email) values (?, ?, ?)";
        return jdbcTemplate.update(insertSQL,new Object[]{
                user.getFirstName(),user.getLastName(),user.getEmail()});
    }
	
    public List<User> getAllUser() {
        String SQL = "select * from User";
        List<User> userList = jdbcTemplate.query(SQL,new UserMapper());
        return userList;
    }
}
