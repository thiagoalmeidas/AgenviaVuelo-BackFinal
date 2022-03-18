package com.agencia.vuelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destino")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_destino;

	@Column(name = "destino_pais")
	private String destinoPais;

	@Column(name = "destino_cidade")
	private String destinoCidade;

	@Column(name = "valor")
	private String valor;

	public Destino() {

	}	
	

	public Destino(int id, String destinoPais, String destinoCidade, String valor) {
		super();
		this.id_destino = id;
		this.destinoPais = destinoPais;
		this.destinoCidade = destinoCidade;
		this.valor = valor;
	}


	public int getId() {
		return id_destino;
	}


	public void setId(int id) {
		this.id_destino = id;
	}


	public String getDestinoPais() {
		return destinoPais;
	}


	public void setDestinoPais(String destinoPais) {
		this.destinoPais = destinoPais;
	}


	public String getDestinoCidade() {
		return destinoCidade;
	}


	public void setDestinoCidade(String destinoCidade) {
		this.destinoCidade = destinoCidade;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}
}