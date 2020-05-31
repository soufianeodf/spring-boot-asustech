package com.fst.asustech.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class MainController {

//	// vente
//	@Autowired
//	@Qualifier("produitsPrixServiceImpl")
//	private CrudService<ProduitsPrix> produitsPrixService;
//
//	@Autowired
//	@Qualifier("commandesServiceImpl")
//	private CrudService<Commandes> commandesService;
//
//	@Autowired
//	@Qualifier("usersServiceImpl")
//	private CrudService<Users> usersService;
//
//	// stock
//	@Autowired
//	@Qualifier("produitsStockServiceImpl")
//	private CrudService<ProduitsStock> produitsStockService;
//
//	@Autowired
//	@Qualifier("produitsApprovisionnementServiceImpl")
//	private CrudService<ProduitsApprovisionnement> produitsApprovisionnementService;
//
//	@GetMapping("/")
//	public String homePage(Model theModel) {
//		return "dashboard/index";
//	}
//
//	@GetMapping("/listProduits")
//	public String listProduits(Model theModel) {
//		theModel.addAttribute("produits", produitsPrixService.findAll());
//		return "dashboard/pages/data-tables";
//	}
}
