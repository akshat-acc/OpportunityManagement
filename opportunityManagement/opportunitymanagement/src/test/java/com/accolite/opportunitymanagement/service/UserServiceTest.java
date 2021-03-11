package com.accolite.opportunitymanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.opportunitymanagement.mapper.UserMapper;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.model.User;
import com.accolite.opportunitymanagement.service.Impl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	
    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    UserServiceImpl userServiceImpl;
    
    @Test
    public void insertUserTest(){
        User user = createUser();
        List<User> userList=userServiceImpl.getAllUser();
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[])Mockito.any()
        )).thenReturn(1);
        Assert.assertEquals(1,userServiceImpl.insert(user));
    }
    
    
    @Test
    public void getAllUserTest(){
        ArrayList<User> userList = new ArrayList<>();
        User user = createUser();
        userList.add(user);
        Mockito.when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(UserMapper.class))).thenReturn(userList);
        Assert.assertEquals(userList.size(),userServiceImpl.getAllUser().size());
    }
    
    private User createUser()
    {
//        User user = new User();
//        user.setUserId(1);
//        user.setFirstName("Accolite");
//        user.setLastName("Digital");
//        user.setEmail("accolite@accolite.digital.com");
//        return user;
    	User user=new User(1,"Acoclite","Digital","accolite@accolitedigital.com");
    	return user;
    }
}
