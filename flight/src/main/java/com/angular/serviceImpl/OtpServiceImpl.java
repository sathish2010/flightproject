package com.angular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.repo.UserRepo;
import com.angular.service.OtpService;
@Service
public class OtpServiceImpl implements OtpService {
@Autowired
UserRepo user;
	@Override
	public void sendOtp(String otp,String email) {

		user.saveOtp(otp,email);
	}
		
}
