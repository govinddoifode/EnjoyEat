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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "branches")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer branchId;

	@Column(length = 30, nullable = false)
	private String branchName;

	@JsonIgnoreProperties("branch")
	@OneToOne
	@JoinColumn(name = "addressId")

	private Address address;

	@JsonIgnoreProperties("branch")
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> order = new ArrayList<>();

	@JsonIgnoreProperties("branch")
	@OneToOne(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BranchManager branchManager;

	@JsonIgnoreProperties("branch")
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DeliveryExecutive> deliveryExecutive = new ArrayList<DeliveryExecutive>();

}
