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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Commandes implements Serializable{

	private static final long serialVersionUID = 8347031137478977762L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_cmd")
	private Integer codeCmd;

	@Column
	private @NonNull String client;

	@Column(name="code_pdt")
	private @NonNull Integer codePdt;

	@Column(name="qte_cmd")
	private @NonNull Integer qteCmd;
	
	@Column(name="date_cmd")
	@Temporal(TemporalType.DATE)
	private @NonNull Date dateCmd;
	
}
