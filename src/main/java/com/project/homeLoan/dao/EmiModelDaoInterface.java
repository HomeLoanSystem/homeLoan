package com.project.homeLoan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.homeLoan.model.EMIModel;

public interface EmiModelDaoInterface extends JpaRepository<EMIModel, Long> {

}
