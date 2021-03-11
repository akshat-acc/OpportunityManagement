package com.accolite.opportunitymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.model.User;
import com.accolite.opportunitymanagement.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/add")
    public int addOpportunity(@RequestBody User user)
    {	
//    	System.out.println("Backend");
        return userServiceImpl.insert(user);
    }
	
	@CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        userList = userServiceImpl.getAllUser();
        return userList;
    }
}
