package com.fst.asustech.dao.g.vente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fst.asustech.entity.g.vente.ProduitsPrix;

@Repository
public interface ProduitsPrixRepository extends JpaRepository<ProduitsPrix, Integer> {

}
