package com.project.capstone.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	private String name;
	private String internalName;
	private String details;
	private int maxProductsPerLocation;
	
}