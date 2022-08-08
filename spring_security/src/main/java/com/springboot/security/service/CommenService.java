package com.springboot.security.service;

import com.springboot.security.entity.Roles;
import com.springboot.security.entity.User1;


public interface CommenService {
	
	Roles addRole(Roles role);
	
	User1 addUsers(User1 user);
	
	
}
