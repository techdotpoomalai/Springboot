package com.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.entity.Roles;
import com.springboot.security.entity.User1;

import com.springboot.security.service.CommenService;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	CommenService commenService;	
	
	@GetMapping("home")
	public String home() {
		return "This is Home.";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "This is admin";
	}
	
	@PostMapping("addrole")
	public Roles add_role(Roles role) {
		return commenService.addRole(role);	
	}
	
	@PostMapping("adduser")
	public User1 add_user(User1 user) {
		return commenService.addUsers(user);
	}
	
	
}
