package com.example.demo.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.Repository;
import com.example.demo.service.UserService;

@Service
public class UserServiceLogic implements UserService{

	private Repository reposite;
	
	public UserServiceLogic(Repository reposirory) {
		super();
		this.reposite = reposirory;
	}


	@Override
	public User Saveuser(User user) {
		// TODO Auto-generated method stub
		return reposite.save(user);
	}

	@Override
	public List<User> getalluser() {
		return reposite.findAll();
		
	}	
	
	@Override
	public void Deleteuser(long id) {
		// TODO Auto-generated method stub
		reposite.deleteById(id);
		
	}


	@Override
	public User Getuserbyid(long id) {
		return reposite.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id));
	}


	@Override
	public User Updateuser(User updateuser, long id) {
		// TODO Auto-generated method stub
		User user=reposite.findById(id).orElseThrow();
		
		user.setName(updateuser.getName());
		user.setPassword(updateuser.getPassword());
		reposite.save(user);
//		System.out.println(user);
		return user;
	}


	




	
}
