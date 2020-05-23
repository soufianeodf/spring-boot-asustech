package com.fst.asustech.dao;

import java.util.List;

public interface CrudDAO<Entity> {
	
	List<Entity> findAll();
	
	Entity findById(Long id);
	
	void save(Entity e);
	
	void deleteById(Long id);
}
