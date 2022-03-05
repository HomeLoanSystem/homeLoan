package com.project.homeLoan.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.homeLoan.dao.LoanDaoInterface;
import com.project.homeLoan.model.LoanModel;

@Service
public class LoanService {
	
	@Autowired
	private LoanDaoInterface loanDao;

	public String processLoanDetails(LoanModel data) {
		
		loanDao.save(data);
		return "ghe re ba return";
		
		
	}

	private String documentHandler(HashMap<String, MultipartFile> fileDetails) {
		String folder ="C:\\Users\\sumit\\Desktop\\ubs";
		
		byte[] bytes = null;
		try {
			bytes = fileDetails.get("file").getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathDb= folder+fileDetails.get("file").getOriginalFilename();
		Path path = Paths.get(pathDb);
		try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathDb;
	}

	public String docHandler(MultipartFile doc) {
		
        String folder ="C:\\Users\\sumit\\Desktop\\ubs\\";
		
		byte[] bytes = null;
		try {
			bytes = doc.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathDb= folder+doc.getOriginalFilename();
		Path path = Paths.get(pathDb);
		try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loanDao.updateDoc(pathDb, 1);
		return pathDb;
	}

}
