package com.fst.asustech.entity.g.stock;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "produits_stock")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProduitsStock implements Serializable{

	private static final long serialVersionUID = 8020985062081280642L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_pdt")
	private Integer codePdt;
	
	@Column(name="qte_pdt")
	private @NonNull Integer qtePdt;

	@Column(name="nom_pdt")
	private @NonNull String nomPdt;

	@Column(name="desc_pdt")
	private @NonNull String descPdt;

	@Column(name="prix_pdt")
	private @NonNull Integer prixPdt;

}
