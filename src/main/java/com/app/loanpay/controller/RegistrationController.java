package com.app.loanpay.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.loanpay.entities.User;
import com.app.loanpay.entities.UserResponse;
import com.app.loanpay.service.RegistrationService;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RegistrationController {
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";
	
//	@Autowired
//    private RegistrationRepository repo;
	@Autowired
	private RegistrationService service;

	    @PostMapping(path ="/registeruser")
	    public UserResponse registerUser(@RequestBody User user)  {
			UserResponse response = new UserResponse();
               System.out.println(user);
//       		user = repo.save(user);
                             
              service.registerUser(user);
                  
//	    	  String tempEmailId =user.getEmailid();
//	    	if(tempEmailId!=null) {
//	      User userobj = service.fetchUserByEmailId(tempEmailId);
//	    		if(userobj !=null) {
//	    				throw new Exception("user with"+tempEmailId+"is already exist");
//	    			
//	    			
//	    		}
//	    		
//	    	}
	    	   if(user!=null) {
	    		   response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data added in DB");
	    		   response.setUser(Arrays.asList(user));

	    		   
	    	   }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not added in DB");
	    		   
	    	   }
	        return response;
	    }
	    
	    @PostMapping("/loginuser")
	    public UserResponse loginUser(@RequestBody User user)  {
			UserResponse response = new UserResponse();

	    	String tempUser = user.getUsername();
	    	String tempPass =  user.getPassword();
	    	  User userObj = null;
	    	  
	       if(tempUser != null && tempPass!= null ) {
	    	   
	    	   
	    	   userObj  = service.fetchUserByusernameAndpassword(tempUser, tempPass);
	    	   
	    	   
	    	   
	    	   
	       }
	       
	       if(userObj == null) {
	    	   
	    	   
	    	   response.setStatusCode(401);
   			   response.setMessage(FAILURE);
   			   response.setDescription("Data not added in DB");
	    	   
	    	   
	       }else {
	    	   
	    	   
	    	   response.setStatusCode(201);
    		   response.setMessage(SUCCESS);
   			   response.setDescription("Login is Successfull");
    		   response.setUser(Arrays.asList(user));

	       }
	    	
	        return response;
	        
	        
	        
	        
	        
	    }
	    
	    

	
	
}
