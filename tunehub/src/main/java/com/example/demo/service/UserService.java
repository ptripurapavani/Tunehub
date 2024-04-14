package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	public String addUser(User user);
	public boolean  emailExists(String email);
	public boolean validUser(String email,String password);

}
