package com.app.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="branch_managers")
public class BranchManager {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "branch_manager_id")
	private int branchManagerId;
	
	@Column(length=30)
	private String firstName;
	
	@Column(length=30)
	private String lastName;
	
	@Column(length=10)
	private String phone;
	
	@Column(length=50)
	private String email;
	
	@JsonIgnoreProperties("branchManager")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@JsonIgnoreProperties("branchManager")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id", referencedColumnName = "login_id")
	private Login login;
	
	@JsonIgnoreProperties("branchManager")
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	@JsonIgnoreProperties("branchManager")
	@OneToMany(mappedBy = "branch")
	private List<DeliveryExecutive> deliveryExecutives;

	public BranchManager(String firstName, String lastName, String phone, String email,Login login,Branch branch,Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.login = login;
		this.branch = branch;
		this.deliveryExecutives = deliveryExecutives;
	}

 

	public BranchManager(String firstName2, String lastName2, String phoneNumber, String emailId, Login persistentlogin,
			Optional<Branch> br, Address persistentaddr) {
		// TODO Auto-generated constructor stub
	}

}
