package com.sapient.springbootdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	CarRepo carRepository;

	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public Car addCar(@RequestBody Car car) {
		carRepository.save(car);
		return car;
	}

	@RequestMapping("/cars")
	public List<Car> home() {
		List<Car> cars = (List<Car>) carRepository.findAll();
		return cars;
	}

}
