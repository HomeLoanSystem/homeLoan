package com.project.homeLoan.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.homeLoan.model.UserModel;
import com.project.homeLoan.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserModel>> getUsers()
	{
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserModel> getUniqueUser(@PathVariable long id)
	{
		return new ResponseEntity<>(userService.getUniqueUser(id),HttpStatus.OK);
	}
	
	@PostMapping(value = "/addUser",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> setUser(@RequestBody UserModel data)
	{
		System.out.println("data is "+ data.getPassword()+" "+data.getUserName());
		return new ResponseEntity<>(userService.setUser(data),HttpStatus.OK);
	}

}
