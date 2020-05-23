package com.fst.asustech.entity.g.stock;

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
public class ProduitsApprovisionnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_pdt")
	private @NonNull Integer codePdt;

	@Column(name="qte_commande")
	private @NonNull Integer qteCommande;
	
	@Column(name="date_livraison")
	@Temporal(TemporalType.DATE)
	private @NonNull Date dateLivraison;
}
