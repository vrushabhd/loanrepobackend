package com.app.loanpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.loanpay.entities.Customer;
import com.app.loanpay.entities.LoanInfo;
import com.app.loanpay.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	public LoanInfo saveloanprograms(LoanInfo loanInfo) {
		
		
		return 	loanRepository.save(loanInfo);
	
	
	}
	
	 public List<LoanInfo> getloanprograms() {
	      
         
			return 	loanRepository.findAll();

		  
		  
		  
		  
		  
		  
	  } 
	  public String  deleteLoan(int id) {
			
		  loanRepository.deleteById(id);
		  return "customer deleted Successfully";
	}
	
	
	  public LoanInfo updateLoan(LoanInfo loanInfo) {
			
			 LoanInfo existingProduct =loanRepository.findById(loanInfo.getLoanid()).orElse(null);
			            existingProduct.setTypeofloan(loanInfo.getTypeofloan());
			            
			            existingProduct.setDetails(loanInfo.getDetails());

			            existingProduct.setDuration(loanInfo.getDuration());
			            existingProduct.setRateofinterest(loanInfo.getRateofinterest());

				
				 return loanRepository.save(existingProduct);
				
	  }
	  
	  
	  
		public LoanInfo getLoanById(int id) {
			
			
			 return  loanRepository.findById(id).orElse(null);
			
			
			
			
			
		}
	  
	  
	  
	  
	  
	  
	  
	  
}
