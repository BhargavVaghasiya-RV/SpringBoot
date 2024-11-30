package com.brgv.dynamic_crud.internal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseModelService<T, R> implements ModelService<T, R> {

	public abstract JpaRepository<T, R> getBaseService();

	@Override
	public <S extends T> S save(S record) {
		return getBaseService().save(record);
	}

	@Override
	public T get(R id) {
		Optional<T> record = getBaseService().findById(id);
		if (record.isPresent()) {
			return record.get();
		}
		return record.orElseThrow();
	}

	@Override
	public List<T> getall() {
		return getBaseService().findAll();
	}

	@Override
	public <S extends T> void delete(S record) {
		getBaseService().delete(record);
	}
}
