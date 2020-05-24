package com.fst.asustech.service.g.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;
import com.fst.asustech.service.CrudService;

@Service
public class ProduitsApprovisionnementServiceImpl implements CrudService<ProduitsApprovisionnement> {

	@Autowired
	@Qualifier("produitsApprovisionnementDAOImpl")
	private CrudDAO<ProduitsApprovisionnement> crudDAO;
	
	@Override
	@Transactional
	public List<ProduitsApprovisionnement> findAll() {
		return crudDAO.findAll();
	}

	@Override
	@Transactional
	public ProduitsApprovisionnement findById(Long id) {
		return crudDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(ProduitsApprovisionnement e) {
		crudDAO.save(e);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		crudDAO.deleteById(id);
	}
		
}
