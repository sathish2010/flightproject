
package com.angular.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.angular.pojo.FlightDetails;

@Repository
public interface FlightRepo extends JpaRepository<FlightDetails, Long>  {

	@Query(value= "select * from tbl_flight_details where departure_location =? and arrival_location=?",nativeQuery =true)
	List <FlightDetails> getFlights(String departureLocation,String arrivalLocation);
	
	@Query(value= "select * from tbl_flight_details where flight_no =? and flight_name=? and departure_location=? and  arrival_location=?",nativeQuery =true)
	FlightDetails getFlightExists(String flightNo, String flightName, String departureLocation, String arrivalLocation);
}
