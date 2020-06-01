package com.fst.asustech.controller.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.service.CrudService;

@ManagedBean
@Component
@SessionScoped
public class BeanProduit {

	// vente
	@Autowired
	@Qualifier("produitsPrixServiceImpl")
	private CrudService<ProduitsPrix> produitsPrixService;
	
	// stock
	@Autowired
	@Qualifier("produitsStockServiceImpl")
	private CrudService<ProduitsStock> produitsStockService;
	
	public List<ProduitsPrix> getListProduitsPrix() {
		return produitsPrixService.findAll();
	}
	
	public List<ProduitsStock> getListProduitsStock() {
		return produitsStockService.findAll();
	}
	
	public List<ProduitsStock> getListProductsFinal() {
		
		List<ProduitsPrix> produitsVente = produitsPrixService.findAll();
		List<ProduitsStock> produits = produitsStockService.findAll();
		
		for (int i = 0; i < produits.size(); i++) {
			produits.get(i).setNomPdt(produitsVente.get(i).getNomPdt());
			produits.get(i).setPrixPdt(produitsVente.get(i).getPrixPdt());
		}
		
		return produits;
	}
}
