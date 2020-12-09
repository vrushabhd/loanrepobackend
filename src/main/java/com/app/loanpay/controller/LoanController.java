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
import com.app.loanpay.entities.LoanInfo;
import com.app.loanpay.entities.User;
import com.app.loanpay.entities.UserResponse;
import com.app.loanpay.service.LoanService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoanController {
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";
	@Autowired
	  private LoanService service;
	  @PostMapping("/addloanprogram")
	  public UserResponse loanProgram(@RequestBody LoanInfo loaninfo)  {
			UserResponse response = new UserResponse();
             System.out.println(loaninfo);
                    service.saveloanprograms(loaninfo);
	    	   if(loaninfo!=null) {
	    		   response.setStatusCode(201);
	    		   response.setMessage(SUCCESS);
	   			   response.setDescription("Data added in DB");
	    		   response.setLoanInfo(Arrays.asList(loaninfo));

	    		   
	    	   }else {
	    		   
	    		   response.setStatusCode(401);
	   			   response.setMessage(FAILURE);
	   			   response.setDescription("Data not added in DB");
	    		   
	    	   }
	        return response;
	    }
	
	
	
	  @GetMapping("/getloanprograms")
		public UserResponse  getloanprograms() {
			UserResponse response = new UserResponse();

			List<LoanInfo> loanprograms = service.getloanprograms();			   
			   if(loanprograms!= null) {
			    	 
			    	 response.setStatusCode(201);
		    		   response.setMessage(SUCCESS);
		   			   response.setDescription("Data found in DB");
		    		   response.setLoanInfo(loanprograms);
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
	
	
	    @DeleteMapping("/deleteprogram/{id}")
	    public UserResponse deleteCustomer(@PathVariable int id) {
		  
			UserResponse response = new UserResponse();

			service.deleteLoan(id);
		  
			response.setStatusCode(201);
			response.setMessage(SUCCESS);
			response.setDescription("Data deleted from DB");
	        return response ;
	    }
	    
	

        @PutMapping("/updateprogram")
	    public UserResponse updateCustomer(@RequestBody LoanInfo loanInfo) {
    		UserResponse response = new UserResponse();

	         
	         LoanInfo  loan  = service.updateLoan(loanInfo);
    		   System.out.println(loan);
			 
    		   if(loan!= null) {
    		    	 
    		    	 response.setStatusCode(201);
    	    		   response.setMessage(SUCCESS);
    	   			   response.setDescription("Data updated in DB");
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
        
        
    	@GetMapping("/getloanById/{id}")
    	public UserResponse  getloanById(@PathVariable int id) {
    		UserResponse response = new UserResponse();

    		LoanInfo applicant = service.getLoanById(id);
    		   System.out.println(applicant);
    		   
    		   if(applicant!= null) {
    		    	 
    		    	 response.setStatusCode(201);
    	    		   response.setMessage(SUCCESS);
    	   			   response.setDescription("Data added in DB");
    	   			   response.setLoanprogram(applicant);
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
        
        
        
}
