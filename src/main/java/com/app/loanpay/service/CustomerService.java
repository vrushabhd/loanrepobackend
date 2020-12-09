package com.app.loanpay.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.loanpay.entities.Customer;
import com.app.loanpay.repository.CustomerRepository;

@Service
public class CustomerService {


	   @Autowired
		private CustomerRepository repo;
	
	  public Customer registerCustomer(Customer customer) {
		  
		            
			return 	repo.save(customer);

		  
		  
		  
		  
		  
		  
	  }
	  public List<Customer> getAllApplicants() {
		      
          
			return 	repo.findAll();

		  
		  
		  
		  
		  
		  
	  }
	  
	  public String  deleteCustomer(int id) {
			
		  repo.deleteById(id);
		  return "customer deleted Successfully";
	}
	
	public Customer getApplicantById(int id) {
		
		
		 return  repo.findById(id).orElse(null);
		
		
		
		
		
	}
	
	public Customer updateFormStatus(int  id) {
		 Customer existingProduct =repo.findById(id).orElse(null);
	
         existingProduct.setFormstatus("Accepted");
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
 	    Calendar calender =Calendar.getInstance();
 	    calender.add(calender.DAY_OF_MONTH,12);
 	     String newDate =formatter.format(calender.getTime());
 	        System.out.println(newDate);
         
         
         
         
         existingProduct.setInterviewdate(newDate);
         
		 
		    return repo.save(existingProduct);
		
	
		
		
	}
	
	public Customer updateFormStatusr(int  id) {
		 Customer existingProduct =repo.findById(id).orElse(null);
	
        existingProduct.setFormstatus("Rejected");
       existingProduct.setInterviewdate("Not Applicable");
        
		 
		    return repo.save(existingProduct);
		
	
		
		
	}
	
	
	
	
//	public Customer setdate(Customer customer) {
//		 Customer existingProduct =repo.findById(customer.getAppid()).orElse(null);
//	
//       existingProduct.setInterviewdate(customer.getInterviewdate());
//      
//       
//		 
//		    return repo.save(existingProduct);
//		
//	
//		
//		
//	}
	
	public Customer updateCustomer(Customer customer) {
		
	 Customer existingProduct =repo.findById(customer.getAppid()).orElse(null);
	            System.out.println(customer.getAppid());
	            existingProduct.setCustomername(customer.getCustomername());
	            existingProduct.setAddress(customer.getAddress());
	            existingProduct.setAnnualincome(customer.getAnnualincome());
	            existingProduct.setGender(customer.getGender());
	            existingProduct.setAssureraddress(customer.getAssureraddress());
	            existingProduct.setAssurercontactnum(customer.getAssurercontactnum());
	            existingProduct.setDateofbirth(customer.getDateofbirth());
	            existingProduct.setEmailid(customer.getEmailid());
	            existingProduct.setLoanamount(customer.getLoanamount());
	            existingProduct.setPhonenumber(customer.getPhonenumber());	  
	            existingProduct.setAssurername(customer.getAssurername());
                existingProduct.setOccupation(customer.getOccupation());
                existingProduct.setLoantype(customer.getLoantype());
                


		
		
		
		
		 return repo.save(existingProduct);
		
	}
	
	
	
	

	
	
	
	
	
}
