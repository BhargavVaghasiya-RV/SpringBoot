package com.brgv.dynamic_crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brgv.dynamic_crud.internal.service.BaseModelService;
import com.brgv.dynamic_crud.model.Product;
import com.brgv.dynamic_crud.repository.ProductRepository;
import com.brgv.dynamic_crud.service.ProductService;

@Service("com.brgv.dynamic_crud.model.Product")
public class ProductServiceImpl extends BaseModelService<Product, Long> implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Long> getBaseService() {
		return productRepository;
	}

	@Override
	public List<Product> findByProductCode(String productCode) {
		
		return productRepository.findByProductCode(productCode);
	}

}
