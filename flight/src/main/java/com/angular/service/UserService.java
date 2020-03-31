package com.angular.service;

import org.springframework.stereotype.Service;

import com.angular.pojo.Users;

@Service
public interface UserService {

	public boolean getUsersExist(Users users);

	public Users getUserLogin(Users users);

	public boolean checkUserExist(Users users);

}
