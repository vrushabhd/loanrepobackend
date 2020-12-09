package com.app.loanpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.loanpay.entities.User;

public interface RegistrationRepository  extends JpaRepository<User, Integer>{


	public User findByemailid(String tempEmailId);
	
	public User findByusernameAndPassword(String username,String password);

}
