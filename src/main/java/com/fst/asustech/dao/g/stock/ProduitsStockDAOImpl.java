package com.fst.asustech.dao.g.stock;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.stock.ProduitsStock;

@Repository
public class ProduitsStockDAOImpl implements CrudDAO<ProduitsStock> {

	@Autowired
	@Qualifier("stockEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<ProduitsStock> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProduitsStock> theQuery = currentSession.createQuery("from ProduitsStock", ProduitsStock.class);
		List<ProduitsStock> e = theQuery.getResultList();
		return e;
	}

	@Override
	public ProduitsStock findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(ProduitsStock.class, id);
	}

	@Override
	public void save(ProduitsStock e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProduitsStock e = currentSession.get(ProduitsStock.class, id);
		currentSession.delete(e);
	}

}
