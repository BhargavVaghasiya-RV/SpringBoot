package com.brgv.dynamic_crud.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.brgv.dynamic_crud.internal.service.ModelService;

public abstract class BaseController<T,R> {
	
	@PostMapping("/save")
	public <S extends T> S save(@RequestBody Object record) {
		ModelService<T, R> myService = applicationContext.getBean(getDTOClass().getName(), ModelService.class);
		return myService.save((S) mapper.map(record, getDTOClass()));
	}
	
	@PostMapping("/delete/{id}")
	public <S extends T> void delete(@PathVariable(name = "id") R id) {
		ModelService<T, R> myService = applicationContext.getBean(getDTOClass().getName(), ModelService.class);
		myService.delete((T) myService.get(id));
	}
	
	@GetMapping("/get/{id}")
	public <T, R> T get(@PathVariable(name = "id") R id) {
		ModelService<T, R> myService = applicationContext.getBean(getDTOClass().getName(), ModelService.class);
		return myService.get(id);
	}
	
	@GetMapping("/get/all")
	public <T, R> List<T> getAll() {
		ModelService<T, R> myService = applicationContext.getBean(getDTOClass().getName(), ModelService.class);
		return myService.getall();
	}

	@Autowired
	public BaseController(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public abstract Class<?> getDTOClass();

	private final ApplicationContext applicationContext;

	private final ModelMapper mapper = new ModelMapper();
	
}
