package com.brgv.dynamic_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brgv.dynamic_crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByProductCode(String productCode);
	
}
