package com.fst.asustech.service;

import java.util.List;

public interface CrudService<Entity> {

	List<Entity> findAll();
	
	Entity findById(Integer id);
	
	void save(Entity e);
	
	void deleteById(Integer id);
}
