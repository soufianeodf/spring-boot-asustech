package com.fst.asustech.service.g.vente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.vente.Commandes;
import com.fst.asustech.service.CrudService;

@Service
public class CommandesServiceImpl implements CrudService<Commandes> {

	@Autowired
	@Qualifier("commandesDAOImpl")
	private CrudDAO<Commandes> crudDAO;
	
	@Override
	@Transactional
	public List<Commandes> findAll() {
		return crudDAO.findAll();
	}

	@Override
	@Transactional
	public Commandes findById(Long id) {
		return crudDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Commandes e) {
		crudDAO.save(e);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		crudDAO.deleteById(id);
	}

}
