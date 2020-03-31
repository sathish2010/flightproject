package com.angular.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity(name="tbl_flightDetails")
@Table(name="tbl_flightDetails")
@ApiModel(description="Details about flight")
public class FlightDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id; 
	@ApiModelProperty(notes="Name of the flight")
	public String flightName;
	public String flightNo;
	public String departureLocation;
	public String arrivalLocation;
	public String arrivalTime;
	public String departureTime;
	public String getArrivalTime() {
		return arrivalTime;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getId() {
		return id;

	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	
	}
	
}
