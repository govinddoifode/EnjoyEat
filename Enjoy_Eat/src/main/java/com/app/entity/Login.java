package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@ToString(exclude = "password")
 
@NoArgsConstructor
@Table(name="logins")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "login_id")
	private int loginId;
	
	@Column(length=20)
	private String role;
	
	@Column(length=20)
	private String password;
	
	@Column(length=10)
	private String userphone;

	@JsonIgnoreProperties("login")
	@OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
		private Customer customer;
	
	@JsonIgnoreProperties("login")
	@OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
		private BranchManager branchmanager;
	
	@JsonIgnoreProperties("login")	
    @OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
    	private DeliveryExecutive deliveryExecutive;

	public Login(String role,String password,String userphone) {
		this.role=role;
		this.password=password;
		this.userphone=userphone;
				
	}

}
