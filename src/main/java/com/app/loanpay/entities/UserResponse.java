package com.app.loanpay.entities;

import java.util.List;



import lombok.Data;

@Data
public class UserResponse {

	private int statusCode;
	private String message;
	private String description;
	private Customer applicant;
	private List<User> user;
	private List<Customer> customer;
	private List<LoanInfo> loanInfo;
	private LoanInfo loanprogram;
 	
	
	
}
