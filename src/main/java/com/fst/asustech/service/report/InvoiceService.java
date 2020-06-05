package com.fst.asustech.service.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fst.asustech.entity.g.vente.Commandes;
import com.fst.asustech.service.g.vente.CommandesServiceImpl;

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
	private CommandesServiceImpl commandesService;

	public void exportReport(String reportFormat, String nameOfCurrentUser) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\soufiane\\Desktop\\workspace\\workspace_javaEE\\asustech\\src\\main\\webapp";
		List<CustomCommande> commandes = new ArrayList<CustomCommande>();
		// transform the data from List<Object[]> to List<CustomCommande>
		commandesService.findUserCommands(nameOfCurrentUser).forEach(command -> {
			commandes.add(new CustomCommande(
					((Commandes) command[0]).getCodeCmd(),
					((Commandes) command[0]).getClient(),
					((Commandes) command[0]).getCodePdt(),
					((Commandes) command[0]).getQteCmd(),
					((Commandes) command[0]).getDateCmd(),
					((Integer) command[1] * ((Commandes) command[0]).getQteCmd())
					));
		});
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:invoice.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(commandes);
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
