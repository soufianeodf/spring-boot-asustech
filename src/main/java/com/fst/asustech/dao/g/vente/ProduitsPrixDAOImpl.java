package com.fst.asustech.dao.g.vente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.vente.ProduitsPrix;

@Repository
public class ProduitsPrixDAOImpl implements CrudDAO<ProduitsPrix> {

	@Autowired
	@Qualifier("venteEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<ProduitsPrix> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProduitsPrix> theQuery = currentSession.createQuery("from ProduitsPrix", ProduitsPrix.class);
		List<ProduitsPrix> e = theQuery.getResultList();
		return e;
	}

	@Override
	public ProduitsPrix findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(ProduitsPrix.class, id);
	}

	@Override
	public void save(ProduitsPrix e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProduitsPrix e = currentSession.get(ProduitsPrix.class, id);
		currentSession.delete(e);
	}

}
