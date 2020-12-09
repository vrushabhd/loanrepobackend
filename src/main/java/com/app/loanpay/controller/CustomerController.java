package com.app.loanpay.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.loanpay.entities.Customer;
import com.app.loanpay.entities.UserResponse;
import com.app.loanpay.service.CustomerService;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CustomerController {
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";
	
    @Autowired
	private CustomerService service;
    
    @DeleteMapping("/delete/{id}")
    public UserResponse deleteCustomer(@PathVariable int id) {
	  
		UserResponse response = new UserResponse();

		service.deleteCustomer(id);
	  
		response.setStatusCode(201);
		response.setMessage(SUCCESS);
		response.setDescription("Data deleted from DB");
        return response ;
    }
    
    
    
	@PostMapping("/addcustomer")
	public UserResponse registerCustomer(@RequestBody Customer customer) {
		
		UserResponse response = new UserResponse();
                 service.registerCustomer(customer);
		     if(customer!= null) {
		    	 
		    	 response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data added in DB");
	    		   response.setCustomer(Arrays.asList(customer));
	    		   response.setUser(null);
		    	 
		    	 
		    	 
		    	 
		     }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not added in DB");
	   			 response.setCustomer(null);
	    		   response.setUser(null);
	    		   
	    	   }
	        return response;
		
		
		
	}
	@GetMapping("/applicants")
	public UserResponse  getAllApplicants() {
		UserResponse response = new UserResponse();

		List<Customer> customers = service.getAllApplicants();
		   System.out.println(customers);
		   
		   if(customers!= null) {
		    	 
		    	 response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data found in DB");
	    		   response.setCustomer(customers);
	    		   response.setUser(null);
		    	 
		    	 
		    	 
		    	 
		     }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not found in DB");
	   			 response.setCustomer(null);
	    		   response.setUser(null);
	    		   
	    	   }
	        return response;
		
		
		
		
	}
	
	@GetMapping("/applicantById/{id}")
	public UserResponse  getApplicantById(@PathVariable int id) {
		UserResponse response = new UserResponse();

		Customer applicant = service.getApplicantById(id);
		   System.out.println(applicant);
		   
		   if(applicant!= null) {
		    	 
		    	 response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data added in DB");
	   			   response.setApplicant(applicant);
	    		   response.setUser(null);
		    	 
		    	 
		    	 
		    	 
		     }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not added in DB");
	   			 response.setCustomer(null);
	    		   response.setUser(null);
	    		   
	    	   }
	        return response;
		
		
		
		
	}
	
	@PutMapping("/applicantByStatus/{id}")
	public UserResponse  updateFormstatus(@PathVariable int id) {
		UserResponse response = new UserResponse();

	Customer  applicant  =  service.updateFormStatus(id);
		   
			 
		   if(applicant!= null) {
		    	 
		    	 response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data updated in DB");
	   			 //  response.setApplicant(applicant.toString());
	    		   response.setUser(null);
		    	 
		    	 
		    	 
		    	 
		     }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not updated in DB");
	   			 response.setCustomer(null);
	    		   response.setUser(null);
	    		   
	    	   }
	        return response;
		
	
	 
	
	
}
	
	
	
//	@PutMapping("/setdate")
//	public UserResponse  updateFormstatusr(@RequestBody Customer customer) {
//		UserResponse response = new UserResponse();
//
//	Customer  applicant  =  service.setdate(customer);
//		   
//			 
//		   if(applicant!= null) {
//		    	 
//		    	 response.setStatusCode(201);
//	    		   response.setMessage(SUCCESS);
//	   			   response.setDescription("Data updated in DB");
//	   			 //  response.setApplicant(applicant.toString());
//	    		   response.setUser(null);
//		    	 
//		    	 
//		    	 
//		    	 
//		     }else {
//	    		   
//	    		   response.setStatusCode(401);
//	   			   response.setMessage(FAILURE);
//	   			   response.setDescription("Data not updated in DB");
//	   			 response.setCustomer(null);
//	    		   response.setUser(null);
//	    		   
//	    	   }
//	        return response;
//	}
		
	        @PutMapping("/applicantByStatusr/{id}")
	    	public UserResponse  updateFormstatusr(@PathVariable int id) {
	    		UserResponse response = new UserResponse();

	    	Customer  applicant  =  service.updateFormStatusr(id);
	    		   
	    			 
	    		   if(applicant!= null) {
	    		    	 
	    		    	 response.setStatusCode(201);
	    	    		   response.setMessage(SUCCESS);
	    	   			   response.setDescription("Data updated in DB");
	    	   			 //  response.setApplicant(applicant.toString());
	    	    		   response.setUser(null);
	    		    	 
	    		    	 
	    		    	 
	    		    	 
	    		     }else {
	    	    		   
	    	    		   response.setStatusCode(401);
	    	   			   response.setMessage(FAILURE);
	    	   			   response.setDescription("Data not updated in DB");
	    	   			 response.setCustomer(null);
	    	    		   response.setUser(null);
	    	    		   
	    	    	   }
	    	        return response;
	    		
	    	        
	
}
	
	
	
	        @PutMapping("/update")
		    public UserResponse updateCustomer(@RequestBody Customer customer) {
	    		UserResponse response = new UserResponse();

		         
		         Customer  applicant  = service.updateCustomer(customer);
	    		   System.out.println(applicant);
    			 
	    		   if(applicant!= null) {
	    		    	 
	    		    	 response.setStatusCode(201);
	    	    		   response.setMessage(SUCCESS);
	    	   			   response.setDescription("Data updated in DB");
	    	   			   response.setApplicant(applicant);
	    	    		   response.setUser(null);
	    		    	 
	    		    	 
	    		    	 
	    		    	 
	    		     }else {
	    	    		   
	    	    		   response.setStatusCode(401);
	    	   			   response.setMessage(FAILURE);
	    	   			   response.setDescription("Data not updated in DB");
	    	   			 response.setCustomer(null);
	    	    		   response.setUser(null);
	    	    		   
	    	    	   }
	    		   
	    		   
	    	        return response;
		         
		         
		         
		         
		         
		         
		         
		         
		         
		         
		         
		         
		         
		         
		    }

	
	
	
	
	
	
	
	
	
	
}
