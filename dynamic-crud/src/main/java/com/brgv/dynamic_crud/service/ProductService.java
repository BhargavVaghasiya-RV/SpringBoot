package com.brgv.dynamic_crud.service;

import java.util.List;

import com.brgv.dynamic_crud.model.Product;

public interface ProductService {
	
	public List<Product> findByProductCode(String productCode);

}
