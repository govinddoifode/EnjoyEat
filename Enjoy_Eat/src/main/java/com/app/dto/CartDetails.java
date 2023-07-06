package com.app.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CartDetails {
	
	private Integer  customerId;
	private Map<Integer,Integer>  menuQuantity;
	private Integer branchId;
	
	
}
