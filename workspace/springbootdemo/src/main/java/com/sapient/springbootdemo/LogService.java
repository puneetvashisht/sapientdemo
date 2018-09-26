package com.sapient.springbootdemo;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	@Autowired
	ILogRepo logRepo;
	
	@Transactional(value=TxType.REQUIRED)
	public void log(String courseName){
		LogEntity log = new LogEntity(courseName);
		logRepo.save(log);
	}

}
