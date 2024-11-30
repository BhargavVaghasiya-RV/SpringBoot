package com.brgv.dynamic_crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.brgv.dynamic_crud.internal.service.BaseModelService;
import com.brgv.dynamic_crud.model.User;
import com.brgv.dynamic_crud.repository.UserRepository;
import com.brgv.dynamic_crud.service.UserService;

@Service("com.brgv.dynamic_crud.model.User")
public class UserServiceImpl extends BaseModelService<User, Long> implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public JpaRepository<User, Long> getBaseService() {
		return userRepository;
	}
}
