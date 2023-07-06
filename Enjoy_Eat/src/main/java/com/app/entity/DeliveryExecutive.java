package com.app.entity;

import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "delivery_executives")
public class DeliveryExecutive {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deliveryExecutiveId;

	@Column(length=50,nullable = false)
	private String firstName;
	@Column(length=50,nullable=false)
	private String lastName;
	@Column(length = 10,unique = true)
	private String phoneNumber;
	@Column(length=70,nullable = false)
	private String emailId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registrationDate;

	@Column(unique=true)
	private Long socialSecurityNumber;


//	private String image;


	@Column(nullable = false)
	private String status;

	

	@JsonIgnoreProperties("deliveryExecutive")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",nullable = false,unique = true)
	private Address address;

	@JsonIgnoreProperties("deliveryExecutive")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id",nullable = false,unique = true)
	private Login login;

	@JsonIgnoreProperties("deliveryExecutive")
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	

	@JsonIgnoreProperties("deliveryExecutive")
	@OneToMany(mappedBy = "deliveryExecutive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();
}
