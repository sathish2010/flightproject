package com.angular.service;

import org.springframework.stereotype.Service;

import com.angular.pojo.Users;
@Service
public interface MailService {

	Users sendMail(String email);

}
