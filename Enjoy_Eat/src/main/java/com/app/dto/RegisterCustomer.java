package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterCustomer {

    	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;

	private String emailId;
	
//	private String role; give default customer in login() constructor
	
	//3. public Customer(String firstName, String lastName, String phoneNumber, String emailId,
//	Address address, Login login) 
		
	private String password;
	//2 .public Login(String role="customer", String password, String userphone ) {
	
	private String streetAddress;
	
	private String city;
	
	private String country;
	
	private int zipcode;
	//1. public Address(String streetAddress, String city, String country, int zipcode) {

	 
	
	
	
	

}
