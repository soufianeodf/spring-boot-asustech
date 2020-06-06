package com.fst.asustech.controller.jsf;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.fst.asustech.entity.g.stock.ProduitsStock;
import com.fst.asustech.entity.g.vente.Commandes;
import com.fst.asustech.entity.g.vente.ProduitsPrix;
import com.fst.asustech.security.config.IAuthenticationFacade;
import com.fst.asustech.service.CrudService;
import com.fst.asustech.service.g.vente.CommandesServiceImpl;
import com.fst.asustech.service.report.InvoiceService;

import net.sf.jasperreports.engine.JRException;

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
	private CommandesServiceImpl commandesService;

	@Autowired
	private InvoiceService service;

	@Autowired
	private IAuthenticationFacade authenticationFacade;

	private int codePdt;
	private int qteCmd;

	private List<ProduitsStock> produits;

	private Logger logger = Logger.getLogger(getClass().getName());

	public BeanProduit() {
		produits = new ArrayList<ProduitsStock>();
	}

	@PostConstruct
	public void init() {
		produits = getListProductsFinal();
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public int getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
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
		logger.info("loading student: ");

		try {
			// get product from database
			ProduitsPrix product = produitsPrixService.findById(codePdt);
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("product", product);
			// set the code pdt attribute to use it in loadPdfAndRedirect()
			setCodePdt(product.getCodePdt());
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

		// create a commande with the product code and the quantity chosen by the
		// current user
		Commandes commande = new Commandes(currentUserNameSimple(), this.codePdt, this.qteCmd, new java.util.Date());
		// save the commande
		commandesService.save(commande);
		
		// get the product by id from g_stock
		ProduitsStock produitsStock = produitsStockService.findById(this.codePdt);
		// soustracte the chosen quantity from the stock quantity
		produitsStock.setQtePdt(produitsStock.getQtePdt() - this.qteCmd);
		// update the quantity value
		produitsStockService.save(produitsStock);

		// generate the invoice
		service.exportReport("pdf", currentUserNameSimple());

		return "/pages/invoice";
	}

	public String currentUserNameSimple() {
		Authentication authentication = authenticationFacade.getAuthentication();
		return authentication.getName();
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
