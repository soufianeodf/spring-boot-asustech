package com.fst.asustech.dao.g.vente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.vente.Users;

@Repository
public class UsersDAOImpl implements CrudDAO<Users> {

	@Autowired
	@Qualifier("venteEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<Users> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Users> theQuery = currentSession.createQuery("from Users", Users.class);
		List<Users> e = theQuery.getResultList();
		return e;
	}

	@Override
	public Users findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Users.class, id);
	}

	@Override
	public void save(Users e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Users e = currentSession.get(Users.class, id);
		currentSession.delete(e);
	}

}
