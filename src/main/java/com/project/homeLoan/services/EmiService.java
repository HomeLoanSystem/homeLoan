package com.project.homeLoan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.EmiModelDaoInterface;

@Service
public class EmiService {

	@Autowired
	private EmiModelDaoInterface emiDao;
}
