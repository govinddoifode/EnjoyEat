package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	@Column(length=30)
	private String firstName;
	
	@Column(length=30)
	private String lastName;
	
	@Column(length=50)
	private String email;
	
	@Column(length=15)
	private String phone;
	
	@JsonIgnoreProperties("customer")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@JsonIgnoreProperties("customer")
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<>();
	
	@JsonIgnoreProperties("customer")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id")
	private Login login;

	public Customer(String firstName, String lastName, String email, String phone, Address address, Login login) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.login = login;
	}
	
}
