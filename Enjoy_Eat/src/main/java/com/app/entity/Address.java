package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId; 
	
	@Column(length=50,nullable = false)
	private String streetAddress;
	@Column(length=50,nullable = false)
	private String city;
	@Column(length=50,nullable = false)
	private String country;
	@Column(length=50,nullable = false)
	private int zipcode;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private Customer customer;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private BranchManager branchManager;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private DeliveryExecutive deliveryExecutive;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private Branch branch;

	public Address(String streetAddress, String city, String country, int zipcode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}



	

}
