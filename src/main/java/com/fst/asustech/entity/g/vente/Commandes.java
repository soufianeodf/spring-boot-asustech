package com.fst.asustech.entity.g.vente;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table
@Data
public class Commandes implements Serializable {

	private static final long serialVersionUID = 8347031137478977762L;

	public Commandes() {
	}

	public Commandes(String currentUserNameSimple, int codePdt, int qteCmd, java.util.Date now) {
		this.client = currentUserNameSimple;
		this.codePdt = codePdt;
		this.qteCmd = qteCmd;
		this.dateCmd = now;
	}

	public Commandes(Integer codeCmd, String client, Integer codePdt, Integer qteCmd) {
		this.codeCmd = codeCmd;
		this.client = client;
		this.codePdt = codePdt;
		this.qteCmd = qteCmd;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_cmd")
	private Integer codeCmd;

	@Column
	private String client;

	@Column(name = "code_pdt")
	private Integer codePdt;

	@Column(name = "qte_cmd")
	private Integer qteCmd;

	@Column(name = "date_cmd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCmd;

}
