package com.sapient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.service.TransferService;
import com.sapient.service.WorkoutService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestTransferService {

	@Autowired
	TransferService service;
	@Autowired
	WorkoutService workoutService;

	@Test
	public void test() {
		
//		TransferService service = context.getBean(TransferService.class);
		service.transfer(123l, 3454, 34535.33);
	}
	@Test
	public void testWorkoutService() {
		workoutService.addWorkout("Run for 5 mins", 80);
	}
	

	

}
