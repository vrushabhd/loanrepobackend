package com.app.loanpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.app.loanpay.repository")


public class LoanpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanpayApplication.class, args);
	}

}
