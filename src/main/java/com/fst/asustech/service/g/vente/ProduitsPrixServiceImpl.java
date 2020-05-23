package com.fst.asustech.service.g.vente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.service.CrudService;


@Service
public class ProduitsPrixServiceImpl implements CrudService<ProduitsPrix> {

	@Autowired
	@Qualifier("produitsPrixDAOImpl")
	private CrudDAO<ProduitsPrix> crudDAO;
	
	@Override
	@Transactional
	public List<ProduitsPrix> findAll() {
		return crudDAO.findAll();
	}

	@Override
	@Transactional
	public ProduitsPrix findById(Long id) {
		return crudDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(ProduitsPrix e) {
		crudDAO.save(e);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		crudDAO.deleteById(id);
	}

}
