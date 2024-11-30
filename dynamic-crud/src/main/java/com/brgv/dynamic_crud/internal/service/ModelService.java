package com.brgv.dynamic_crud.internal.service;

import java.util.List;

public interface ModelService<T, R> {

	public <S extends T> S save(S record);

	public T get(R id);

	public List<T> getall();

	public <S extends T> void delete(S record);
}
