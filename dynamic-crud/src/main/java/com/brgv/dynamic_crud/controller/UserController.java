package com.brgv.dynamic_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brgv.dynamic_crud.model.User;
import com.brgv.dynamic_crud.service.UserService;

@RestController
@RequestMapping("users/")
public class UserController extends BaseController<User, Long> {
	
	@Autowired
	UserService userService;

	public UserController(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	public Class<?> getDTOClass() {
		return User.class;
	}
}
