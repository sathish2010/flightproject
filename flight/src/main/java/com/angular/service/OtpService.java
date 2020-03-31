package com.angular.service;

import org.springframework.stereotype.Service;
@Service
public interface OtpService {
	void sendOtp(String otp,String email);

}
