package com.fst.asustech.service.g.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fst.asustech.dao.g.vente.ProduitsPrixRepository;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.service.CrudService;

@Service
public class ProduitsPrixServiceImpl implements CrudService<ProduitsPrix> {

	@Autowired
	@Qualifier("produitsPrixRepository")
	private ProduitsPrixRepository produitsPrixRepository;

	@Override
	public List<ProduitsPrix> findAll() {
		return produitsPrixRepository.findAll();
	}

	@Override
	public ProduitsPrix findById(Integer id) {
		Optional<ProduitsPrix> result = produitsPrixRepository.findById(id);
		ProduitsPrix produitsPrix = null;
		if (result.isPresent()) {
			produitsPrix = result.get();
		} else {
			throw new RuntimeException("Did not find produitsPrix");
		}
		return produitsPrix;
	}

	@Override
	public void save(ProduitsPrix e) {
		produitsPrixRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		produitsPrixRepository.deleteById(id);
	}

}
