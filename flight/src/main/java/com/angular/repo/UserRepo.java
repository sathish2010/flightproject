package com.angular.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.angular.pojo.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

	@Query(value= "select * from tbl_user_details where email =?",nativeQuery =true)
	Users getUsersExist(String email);
	
	@Query(value= "select * from tbl_user_details where email =? and password=?",nativeQuery =true)
	Users getUserLogin(String email,String password);

	@Query(value="select * from tbl_user_details where email=?",nativeQuery=true)
	Users checkUserExist(String email);
	@Transactional
	@Modifying
	@Query(value="update tbl_user_details set otp=? where email=?",nativeQuery=true) 
	void saveOtp(String otp,String email);
}
