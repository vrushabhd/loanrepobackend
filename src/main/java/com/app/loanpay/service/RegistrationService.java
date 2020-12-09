package com.app.loanpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.loanpay.entities.User;
import com.app.loanpay.repository.RegistrationRepository;



@Service
public class RegistrationService {

	
	
	   @Autowired
		private RegistrationRepository repository;
		
		public User registerUser(User user) {
			
			
			return 	repository.save(user);
		
		
		}
		
		

		public User fetchUserByEmailId(String tempEmailId) {
			// TODO Auto-generated method stub
			return repository.findByemailid(tempEmailId);
		}
		
		public User fetchUserByusernameAndpassword(String username,String password) {
			// TODO Auto-generated method stub
			return repository.findByusernameAndPassword(username,password);
		}
	
}
