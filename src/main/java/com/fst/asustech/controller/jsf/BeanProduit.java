package com.fst.asustech.controller.jsf;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.service.CrudService;
import com.fst.asustech.service.report.InvoiceService;

import net.sf.jasperreports.engine.JRException;

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
	
	@Autowired
	private InvoiceService service;

	private List<ProduitsStock> produits;
	private Logger logger = Logger.getLogger(getClass().getName());

	public BeanProduit() {
		produits = new ArrayList<ProduitsStock>();
	}

	@PostConstruct
	public void init() {
		produits = getListProductsFinal();
	}

	public List<ProduitsStock> getProduits() {
		return produits;
	}

	public List<ProduitsPrix> getListProduitsPrix() {
		return produitsPrixService.findAll();
	}

	public List<ProduitsStock> getListProduitsStock() {
		return produitsStockService.findAll();
	}

	public List<ProduitsStock> getListProductsFinal() {

		List<ProduitsPrix> produitsVente = getListProduitsPrix();
		List<ProduitsStock> produits = getListProduitsStock();

		for (int i = 0; i < produits.size(); i++) {
			produits.get(i).setNomPdt(produitsVente.get(i).getNomPdt());
			produits.get(i).setPrixPdt(produitsVente.get(i).getPrixPdt());
		}

		return produits;
	}

	public String loadProduct(int codePdt) {

		logger.info("loading student: " + codePdt);

		try {
			// get product from database
			ProduitsPrix product = produitsPrixService.findById(codePdt);

			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("product", product);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading product id:" + codePdt, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "/pages/form-validation";
	}
	
	@Transactional
	public String loadPdfAndRedirect() throws FileNotFoundException, JRException {
		
		service.exportReport("pdf");
		
		return "/pages/invoice";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
