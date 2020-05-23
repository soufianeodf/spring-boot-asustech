package com.fst.asustech.dao.g.vente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.vente.Commandes;

@Repository
public class CommandesDAOImpl implements CrudDAO<Commandes> {

	@Autowired
	@Qualifier("venteEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<Commandes> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Commandes> theQuery = currentSession.createQuery("from Commandes", Commandes.class);
		List<Commandes> e = theQuery.getResultList();
		return e;
	}

	@Override
	public Commandes findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Commandes.class, id);
	}

	@Override
	public void save(Commandes e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Commandes e = currentSession.get(Commandes.class, id);
		currentSession.delete(e);
	}

}
