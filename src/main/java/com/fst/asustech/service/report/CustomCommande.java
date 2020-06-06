package com.fst.asustech.service.report;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CustomCommande implements Serializable {

	private static final long serialVersionUID = 8585240247025308043L;

	public CustomCommande(Integer codeCmd, String client, Integer codePdt, Integer qteCmd, Date dateCmd,
			Integer total) {
		this.codeCmd = codeCmd;
		this.client = client;
		this.codePdt = codePdt;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
		this.total = total;
	}

	public CustomCommande() {
	}

	private Integer codeCmd;

	private String client;

	private Integer codePdt;

	private Integer qteCmd;

	private Date dateCmd;

	private Integer total;

}