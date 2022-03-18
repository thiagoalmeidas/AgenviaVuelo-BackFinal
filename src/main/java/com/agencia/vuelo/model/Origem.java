package com.agencia.vuelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "origem")
public class Origem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_origem;

	@Column(name = "origem_pais")
	private String origemPais;

	@Column(name = "origem_cidade")
	private String origemCidade;

	@Column(name = "valor")
	private String valor;

	public Origem() {

	}	
	

	public Origem(int id, String origemPais, String origemCidade, String valor) {
		super();
		this.id_origem = id;
		this.origemPais = origemPais;
		this.origemCidade = origemCidade;
		this.valor = valor;
	}


	public int getId() {
		return id_origem;
	}


	public void setId(int id) {
		this.id_origem = id;
	}


	public String getOrigemPais() {
		return origemPais;
	}


	public void setOrigemPais(String origemPais) {
		this.origemPais = origemPais;
	}


	public String getOrigemCidade() {
		return origemCidade;
	}


	public void setOrigemCidade(String origemCidade) {
		this.origemCidade = origemCidade;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}
}