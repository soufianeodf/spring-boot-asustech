package com.fst.asustech.service.g.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fst.asustech.dao.g.stock.ProduitsStockRepository;
import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.service.CrudService;

@Service
public class ProduitsStockServiceImpl implements CrudService<ProduitsStock> {

	@Autowired
	@Qualifier("produitsStockRepository")
	private ProduitsStockRepository produitsStockRepository;

	@Override
	public List<ProduitsStock> findAll() {
		return produitsStockRepository.findAll();
	}

	@Override
	public ProduitsStock findById(Integer id) {
		Optional<ProduitsStock> result = produitsStockRepository.findById(id);
		ProduitsStock produitsStock = null;
		if (result.isPresent()) {
			produitsStock = result.get();
		} else {
			throw new RuntimeException("Did not find produitsStock");
		}
		return produitsStock;
	}

	@Override
	public void save(ProduitsStock e) {
		produitsStockRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		produitsStockRepository.deleteById(id);
	}

}
