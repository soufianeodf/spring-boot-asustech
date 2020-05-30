package com.fst.asustech.entity.g.stock;

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
@Table(name="produits_approvisionnement")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProduitsApprovisionnement implements Serializable{

	private static final long serialVersionUID = -2076610635317007311L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_pdt")
	private @NonNull Integer codePdt;

	@Column(name="qte_commande")
	private @NonNull Integer qteCommande;
	
	@Column(name="date_prevue_livraison")
	@Temporal(TemporalType.DATE)
	private @NonNull Date datePrevueLivraison;
}
