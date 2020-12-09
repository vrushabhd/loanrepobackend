package com.app.loanpay.entities;

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
@Table(name ="loaninfo")
public class LoanInfo {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanid;
	private String  typeofloan;
	private int duration;
	private int details;
	private int rateofinterest;
	
	
}
