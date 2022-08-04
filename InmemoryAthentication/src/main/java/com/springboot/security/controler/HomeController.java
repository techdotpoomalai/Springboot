package com.springboot.security.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("home")
	public String home() {
		return "This is Home.";
	}
	
	@GetMapping("user")
	public String user() {
		return "this is user";
	}
	
	@GetMapping("useradmin")
	public String useradmin() {
		return "this is user and admin";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "this is admin";
	}
}
