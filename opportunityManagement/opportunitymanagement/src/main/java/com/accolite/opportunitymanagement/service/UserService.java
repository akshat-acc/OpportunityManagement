package com.accolite.opportunitymanagement.service;

import java.util.List;

import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.model.User;

public interface UserService {
	public int insert(User user);
	public List<User> getAllUser();
}
