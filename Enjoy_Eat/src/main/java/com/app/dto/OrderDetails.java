package com.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDetails {
	 
	  Integer customerId;
	  Integer branchId;
	  List<MenuDetails> menuDetails;
	  

}
