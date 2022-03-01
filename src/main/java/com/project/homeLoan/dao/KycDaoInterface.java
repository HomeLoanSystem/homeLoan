package com.project.homeLoan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.homeLoan.model.KycModel;


public interface KycDaoInterface extends JpaRepository<KycModel, Long>{

}
