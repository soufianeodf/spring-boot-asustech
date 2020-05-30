
DROP database if exists g_stock;
create database g_stock;
use g_stock;

CREATE TABLE `produits_stock` (
  `code_pdt` int NOT NULL AUTO_INCREMENT,
  `qte_pdt` int DEFAULT NULL,
  `nom_pdt` varchar(20) DEFAULT NULL,
  `desc_pdt` varchar(200) DEFAULT NULL,
  `prix_pdt` int(11) DEFAULT NULL,
	PRIMARY KEY (`code_pdt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `produits_approvisionnement` (
  `code_pdt` int NOT NULL AUTO_INCREMENT,
  `qte_commande` int DEFAULT NULL,
  `date_prevue_livraison` date DEFAULT NULL,
	PRIMARY KEY (`code_pdt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


