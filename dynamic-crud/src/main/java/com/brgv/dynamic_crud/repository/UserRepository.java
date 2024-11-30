package com.brgv.dynamic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brgv.dynamic_crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
