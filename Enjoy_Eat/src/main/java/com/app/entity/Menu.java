package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
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
@Table(name="menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int menuId;
	
	
	@Column(length=30,nullable = false)
	private String menuName;
	
	@Column(length=30,nullable = false)
	private String category;
	
	@Column(nullable = false)
	@Lob
	private String imagePath;

	
	@Column(nullable = false)
	private double rate;
	
	@JsonIgnoreProperties("menu")
	@OneToMany(mappedBy="menu",fetch = FetchType.LAZY)
	private List<OrderItem> orderItem=new ArrayList<OrderItem>();

	public Menu(int menuId, String menuName, String category, String imagePath, double rate) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.category = category;
		this.imagePath = imagePath;
		this.rate = rate;
	}


}
