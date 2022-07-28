package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.example.demo.model.User;

public interface UserService {
	
	User Saveuser(User user);
	
	List<User> getalluser();
	
	User Getuserbyid(long id);
	
	User Updateuser(User updateuser, long id);
	
	void Deleteuser(long id);
}
