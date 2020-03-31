package com.angular.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angular.pojo.FlightDetails;


@Service
public interface FlightService {
	
	public List<FlightDetails> getFlights(FlightDetails flight);

	public FlightDetails addFlights(FlightDetails flight);
}
