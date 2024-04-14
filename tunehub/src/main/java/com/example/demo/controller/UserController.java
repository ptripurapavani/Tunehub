package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired UserService service;
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user ) {
		boolean userStatus=service.emailExists(user.getEmail());
		if(userStatus==false) {
			service.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("email already exists");
		}
		
		return "home";
	}
	@PostMapping("/validate")
public String valid(@RequestParam("email") String email,@RequestParam("password") String password) {
	
	if(service.validUser(email,password)==true) {
		return "home";
	}
	else {
		return "login";
	}
}
}
