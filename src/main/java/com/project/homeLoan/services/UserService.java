package com.project.homeLoan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.UserDaoInterface;
import com.project.homeLoan.model.UserModel;

@Service
public class UserService {
	
	
	@Autowired
	private UserDaoInterface userDao;
	
	public List<UserModel> getAllUsers()
	{
		return userDao.findAll();
	}

	public UserModel getUniqueUser(long id)
	{
		return userDao.getById(id);
	}
}
