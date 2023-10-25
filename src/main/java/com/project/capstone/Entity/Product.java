package com.project.capstone.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	private String internalName;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	private String details;

	public int getMaxProductsPerLocation() {
		return maxProductsPerLocation;
	}

	public void setMaxProductsPerLocation(int maxProductsPerLocation) {
		this.maxProductsPerLocation = maxProductsPerLocation;
	}

	private int maxProductsPerLocation;

	public double getPrice() {
		return 0;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private double price;

	private String imageURL;
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}