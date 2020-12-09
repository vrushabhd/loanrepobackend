package com.app.loanpay.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="customer")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column( name = "appid")
	private int appid;
//	@Column( name = "customername")
	private String customername;
//	@Column( name = "phonenumber")
	private String phonenumber;
//	@Column( name = "phonenumber")

	private String emailid;
	private String gender;
	private String dateofbirth;
	private String occupation;
	private double annualincome;
	private String address;
	private String assurername;
	private String assurercontactnum;
	private String assureraddress;
	private String loantype;
	private double loanamount;
	private String formstatus;
	private String interviewdate;



	
	
	
	
	
	
}
