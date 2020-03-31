package com.angular.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.angular.pojo.FlightDetails;
import com.angular.repo.FlightRepo;
import com.angular.service.FlightService;

@Service
@Qualifier("flightService")
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepo flightRepo;

	public List<FlightDetails> getFlights(FlightDetails flight) {
		List<FlightDetails> flightDetails = flightRepo.getFlights(flight.getDepartureLocation(),
				flight.getArrivalLocation());
		/*for (FlightDetails fd : flightDetails) {
			System.out.println(fd.departureLocation);
			System.out.println(fd.arrivalLocation);

		}*/
		if (flightDetails != null) {
			return flightDetails;
		} else {
			return null;
		}
	}

	@Override
	public FlightDetails addFlights(FlightDetails flight) {
		
		FlightDetails flight1 = flightRepo.getFlightExists(flight.getFlightNo(),flight.getFlightName(),flight.getDepartureLocation(),flight.getArrivalLocation());
			if(flight1!=null) {
				return flight1;
			}
			else {
	       flightRepo.save(flight);
		   return null ;
	       }
	}
}


