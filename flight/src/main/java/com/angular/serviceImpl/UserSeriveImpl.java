package com.angular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.pojo.Users;
import com.angular.repo.UserRepo;
import com.angular.service.MailService;
import com.angular.service.UserService;

@Service
public class UserSeriveImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	MailService mailService;

	public boolean getUsersExist(Users users) {
		Users usersExist = userRepo.getUsersExist(users.getEmail());

		if (usersExist != null) {
			return true;
		} else {
			userRepo.save(users);
			return false;
		}
	}

	public Users getUserLogin(Users users) {
		Users userLogin = userRepo.getUserLogin(users.getEmail(), users.getPassword());

		if (userLogin != null) {
			return userLogin;
		} else {
			return null;
		}
	}

	public boolean checkUserExist(Users users) {
		Users checkUser = userRepo.checkUserExist(users.getEmail());

		if (checkUser != null) {
		  mailService.sendMail(users.getEmail());
			return true;

		} else {
			return false;
		}
	}
}
