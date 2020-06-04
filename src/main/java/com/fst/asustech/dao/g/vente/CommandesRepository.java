package com.fst.asustech.dao.g.vente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fst.asustech.entity.g.vente.Commandes;

@Repository
public interface CommandesRepository extends JpaRepository<Commandes, Integer>, CommandesRepositoryCustom {

}
