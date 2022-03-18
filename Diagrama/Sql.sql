CREATE DATABASE agenciavuelo;

USE agenciavuelo;


CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8

CREATE TABLE `destino` (
  `id_destino` int(11) NOT NULL AUTO_INCREMENT,
  `destino_pais` varchar(45) DEFAULT NULL,
  `destino_cidade` varchar(45) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_destino`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8

CREATE TABLE `origem` (
  `id_origem` int(11) NOT NULL AUTO_INCREMENT,
  `origem_pais` varchar(45) DEFAULT NULL,
  `origem_cidade` varchar(45) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_origem`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8

CREATE TABLE `pacote` (
  `id_pacote` int(11) NOT NULL,
  `id_destino` int(11) DEFAULT NULL,
  `id_origem` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pacote`),
  KEY `FKrn19rtttxjk7hfy9303tkemoi` (`id_destino`),
  KEY `FK2nt3bl0w5vhotkjd37ed05bd4` (`id_origem`),
  KEY `FK2pg8qcgbgouiak95dvvj7dfeh` (`id_usuario`),
  CONSTRAINT `FK2nt3bl0w5vhotkjd37ed05bd4` FOREIGN KEY (`id_origem`) REFERENCES `origem` (`id_origem`),
  CONSTRAINT `FK2pg8qcgbgouiak95dvvj7dfeh` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKrn19rtttxjk7hfy9303tkemoi` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Pagamento` (
  `id_Pagamento` int(11) NOT NULL,
  `tipo_pagamento` varchar(45) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `pacote_id` int(11) NOT NULL,
  PRIMARY KEY (`id_Pagamento`),
  KEY `fk_Pagamento_pacote1_idx` (`pacote_id`),
  CONSTRAINT `fk_Pagamento_pacote1` FOREIGN KEY (`pacote_id`) REFERENCES `pacote` (`id_pacote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8