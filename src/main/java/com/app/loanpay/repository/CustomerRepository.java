package com.app.loanpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.loanpay.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
}
