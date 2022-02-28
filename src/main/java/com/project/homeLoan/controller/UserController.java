package com.project.homeLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.model.UserModel;
import com.project.homeLoan.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public List<UserModel> getUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/users/{id}")
	public UserModel getUniqueUser(@PathVariable long id)
	{
		return userService.getUniqueUser(id);
	}
	

}
