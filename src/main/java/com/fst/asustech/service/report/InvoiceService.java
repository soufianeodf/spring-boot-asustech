package com.fst.asustech.service.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fst.asustech.dao.g.vente.CommandesRepository;
import com.fst.asustech.entity.g.vente.Commandes;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class InvoiceService {

	@Autowired
	@Qualifier("commandesRepository")
	private CommandesRepository repository;

	public void exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\soufiane\\Desktop\\workspace\\workspace_javaEE\\asustech\\src\\main\\resources";
		List<Commandes> commande = repository.findAll();
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:invoice.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(commande);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Faculté des sciences tétouan");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//		if (reportFormat.equalsIgnoreCase("html")) {
//			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
//		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\facture.pdf");
		}

	}
}
