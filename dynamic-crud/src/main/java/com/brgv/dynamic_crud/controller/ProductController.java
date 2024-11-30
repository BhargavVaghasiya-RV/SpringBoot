package com.brgv.dynamic_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brgv.dynamic_crud.model.Product;
import com.brgv.dynamic_crud.service.ProductService;

@RestController
@RequestMapping("products/")
public class ProductController extends BaseController<Product, Long> {

	public ProductController(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	public Class<?> getDTOClass() {
		return Product.class;
	}
	
	
	@GetMapping("type/{productCode}")
	public List<Product> getByType(@PathVariable(name = "productCode") String productCode) {
		return productService.findByProductCode(productCode);
	}
	
	@Autowired
	ProductService productService;

}
