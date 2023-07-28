package com.devpaula.PaoKemtim.Repositories;

import java.util.List;

public interface GenericRepository <T, I> {
	public void create(T t);
	public void update(T t);
	public T read(I key);
	public void delete(I key);
	public List<T> readAll();

}
