package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserControler {
	@Autowired
	private UserService userservice;

	public UserControler(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	@PostMapping("/new")
	public String SaveUser(@RequestBody User user) {
		userservice.Saveuser(user);
		return "You added successfully...!";
	}
	
	@GetMapping("/get")
	public List<User> Getalluser(){
		return userservice.getalluser();		
	}
	
	@DeleteMapping("/delete/{id}")
	public String Deleteauser(@PathVariable("id") long id) {
		userservice.Deleteuser(id);
		return "Deleted Successfully...!";
	}
	
	@GetMapping("getuser/{id}")
	public User Getuser(@PathVariable("id") long id) {
		return userservice.Getuserbyid(id);
	}
	
	@PutMapping("/update/{id}")
	public User Updateuser(@PathVariable("id") long id, @RequestBody User user) {
		return userservice.Updateuser(user, id);		
	}
	
	
	
}
