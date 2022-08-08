package com.springboot.security.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.security.entity.Roles;
import com.springboot.security.entity.User1;
import com.springboot.security.repository.RoleRepository;
import com.springboot.security.repository.UserRepository;
import com.springboot.security.service.CommenService;

@Service
public class CommenServiceImplementatoin implements CommenService{

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Roles addRole(Roles role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public User1 addUsers(User1 user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
