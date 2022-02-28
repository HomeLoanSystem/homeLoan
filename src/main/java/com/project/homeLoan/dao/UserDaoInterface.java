package com.project.homeLoan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.homeLoan.model.UserModel;

public interface UserDaoInterface extends JpaRepository<UserModel,Long>{

}