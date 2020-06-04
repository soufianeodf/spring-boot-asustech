package com.fst.asustech.service.report;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class CustomCommande implements Serializable {

	private static final long serialVersionUID = 8585240247025308043L;

	public CustomCommande(@NonNull Integer codeCmd, @NonNull String client, @NonNull Integer codePdt,
			@NonNull Integer qteCmd, @NonNull Date dateCmd, @NonNull Integer total) {
		super();
		this.codeCmd = codeCmd;
		this.client = client;
		this.codePdt = codePdt;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
		this.total = total;
	}

	public CustomCommande() {
	}

	private @NonNull Integer codeCmd;

	private @NonNull String client;

	private @NonNull Integer codePdt;

	private @NonNull Integer qteCmd;

	private @NonNull Date dateCmd;

	private @NonNull Integer total;

}