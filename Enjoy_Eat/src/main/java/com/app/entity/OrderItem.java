package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int orderItemId;
	
	
	private double amount;
	
	@Column(nullable = false)
	private int quantity;
	
	@JsonIgnoreProperties("orderItem")
	@ManyToOne
	@JoinColumn(name="menuId")
	private Menu menu;
	
	@JsonIgnoreProperties("orderItem")
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;


}
