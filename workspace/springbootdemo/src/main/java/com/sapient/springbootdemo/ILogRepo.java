package com.sapient.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogRepo extends JpaRepository<LogEntity, Integer>{

		
}
