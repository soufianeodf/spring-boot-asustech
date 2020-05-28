package com.fst.asustech.dao.g.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;

@Repository
public interface ProduitsApprovisionnementRepository extends JpaRepository<ProduitsApprovisionnement, Integer> {

}
