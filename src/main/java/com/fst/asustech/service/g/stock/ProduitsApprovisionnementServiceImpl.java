package com.fst.asustech.service.g.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fst.asustech.dao.g.stock.ProduitsApprovisionnementRepository;
import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;
import com.fst.asustech.service.CrudService;

@Service
public class ProduitsApprovisionnementServiceImpl implements CrudService<ProduitsApprovisionnement> {

	@Autowired
	@Qualifier("produitsApprovisionnementRepository")
	private ProduitsApprovisionnementRepository produitsApprovisionnementRepository;

	@Override
	public List<ProduitsApprovisionnement> findAll() {
		return produitsApprovisionnementRepository.findAll();
	}

	@Override
	public ProduitsApprovisionnement findById(Integer id) {
		Optional<ProduitsApprovisionnement> result = produitsApprovisionnementRepository.findById(id);
		ProduitsApprovisionnement produitsApprovisionnement = null;
		if (result.isPresent()) {
			produitsApprovisionnement = result.get();
		} else {
			throw new RuntimeException("Did not find produitsApprovisionnement");
		}
		return produitsApprovisionnement;
	}

	@Override
	public void save(ProduitsApprovisionnement e) {
		produitsApprovisionnementRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		produitsApprovisionnementRepository.deleteById(id);
	}

}
