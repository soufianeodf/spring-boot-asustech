
DROP database if exists g_vente;
create database g_vente;
use g_vente;

CREATE TABLE `produits_prix` (
  `code_pdt` int NOT NULL AUTO_INCREMENT,
  `nom_pdt` varchar(20) DEFAULT NULL,
  `desc_pdt` varchar(200) DEFAULT NULL,
  `prix_pdt` int(11) DEFAULT NULL,
	PRIMARY KEY (`code_pdt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commandes` (
  `code_cmd` int NOT NULL AUTO_INCREMENT,
  `client` varchar(20) DEFAULT NULL,
  `code_pdt` int DEFAULT NULL,
  `qte_cmd` int DEFAULT NULL,
  `date_cmd` date DEFAULT NULL,
	PRIMARY KEY (`code_cmd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*DROP TABLE IF EXISTS `users`*/;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

/*DROP TABLE IF EXISTS `authorities`*/;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');