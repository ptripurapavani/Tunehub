package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImp implements UserService {

	@Autowired UserRepository repo;
	public String addUser(User user) {
		repo.save(user);
		return "saved successfully";
	}
	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
		return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validUser(String email, String password) {
		User user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}
		else {
			return false;
		}
	
	
	}

}
