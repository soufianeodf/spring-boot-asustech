package com.fst.asustech.controller.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;
import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.entity.g.vente.Commandes;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.entity.g.vente.Users;
import com.fst.asustech.service.CrudService;

@Controller
public class MainController {

	// vente
	@Autowired
	@Qualifier("produitsPrixServiceImpl")
	private CrudService<ProduitsPrix> produitsPrixService;

	@Autowired
	@Qualifier("commandesServiceImpl")
	private CrudService<Commandes> commandesService;

	@Autowired
	@Qualifier("usersServiceImpl")
	private CrudService<Users> usersService;

	// stock
	@Autowired
	@Qualifier("produitsStockServiceImpl")
	private CrudService<ProduitsStock> produitsStockService;

	@Autowired
	@Qualifier("produitsApprovisionnementServiceImpl")
	private CrudService<ProduitsApprovisionnement> produitsApprovisionnementService;

	@GetMapping("/")
	public String homePage() {
		return "/index.xhtml";
	}

	@GetMapping("/listProduits")
	public String listProduits() {
		return "/pages/data-tables.xhtml";
	}
}
