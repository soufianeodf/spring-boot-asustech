package com.fst.asustech.service.g.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.service.CrudService;


@Service
public class ProduitsStockServiceImpl implements CrudService<ProduitsStock> {

	@Autowired
	@Qualifier("produitsStockDAOImpl")
	private CrudDAO<ProduitsStock> crudDAO;
	
	@Override
	@Transactional
	public List<ProduitsStock> findAll() {
		return crudDAO.findAll();
	}

	@Override
	@Transactional
	public ProduitsStock findById(Long id) {
		return crudDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(ProduitsStock e) {
		crudDAO.save(e);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		crudDAO.deleteById(id);
	}

}
