package com.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.angular.pojo.FlightDetails;
import com.angular.pojo.Users;
import com.angular.repo.FlightRepo;
import com.angular.service.FlightService;
import com.angular.service.UserService;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class angularController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FlightRepo flightRepo;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/flightSearch")
	public @ResponseBody List<FlightDetails> flightSearch(@RequestBody FlightDetails flight){
		return flightService.getFlights(flight);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/registration")
	@ApiOperation(value="Register User", notes="Register a User for Flight Booking")
	public @ResponseBody  boolean register(@RequestBody Users users, String hai){
		return userService.getUsersExist(users);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/login")
	public @ResponseBody  Users login(@RequestBody Users users){
		return userService.getUserLogin(users);
	}
	@CrossOrigin(origins="http://localhost:4200")		
	@PostMapping(value="/addFlights")
	public @ResponseBody FlightDetails addFlights(@RequestBody FlightDetails flight)
	{
		return flightService.addFlights(flight);
		
	}
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/checkUsers")
	public @ResponseBody boolean checkUsers(@RequestBody Users users) {
		return userService.checkUserExist(users);
	}
	
	@GetMapping(value="/getFlights")
	public List<FlightDetails> getFlights() {
	List<FlightDetails> flight = flightRepo.findAll();
	return  flight;
	}
}

