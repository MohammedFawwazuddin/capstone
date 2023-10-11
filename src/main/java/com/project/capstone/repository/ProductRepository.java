package com.project.capstone.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.capstone.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}