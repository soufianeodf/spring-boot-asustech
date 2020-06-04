//package com.fst.asustech.controller.springmvc;
//
//import java.io.FileNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;
//import com.fst.asustech.entity.g.stock.ProduitsStock;
//import com.fst.asustech.entity.g.vente.Commandes;
//import com.fst.asustech.entity.g.vente.ProduitsPrix;
//import com.fst.asustech.service.CrudService;
//import com.fst.asustech.service.g.vente.CommandesServiceImpl;
//import com.fst.asustech.service.report.InvoiceService;
//
//import net.sf.jasperreports.engine.JRException;
//
//@Controller
//public class MainController {
//
//	// vente
//	@Autowired
//	@Qualifier("produitsPrixServiceImpl")
//	private CrudService<ProduitsPrix> produitsPrixService;
//
//	@Autowired
//	private CommandesServiceImpl commandesService;
//
////	@Autowired
////	@Qualifier("usersServiceImpl")
////	private CrudService<Users> usersService;
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
//	@Autowired
//	private InvoiceService service;
//
//	@GetMapping("/")
//	public String homePage() {
//		commandesService.findUserCommands("susan").forEach(command -> {
//			System.out.println(((Commandes) command[0]).getCodeCmd() + " " + command[1]);
//		});
//		return "index.xhtml";
//	}
//
//	@GetMapping("/listProduits")
//	public String listProduits() {
//		return "pages/data-tables.xhtml";
//	}
//
//	@GetMapping("/formValidation")
//	public String formValidation() {
//		return "pages/form-validation.xhtml";
//	}
//	
//    @GetMapping("/report/{format}")
//    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//    	service.exportReport(format);
//        return "redirect:../";
//    }
//
//}
