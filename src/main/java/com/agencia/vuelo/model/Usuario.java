package com.agencia.vuelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;

	@Column(name = "nome")
	private String nomeUsuario;

	@Column(name = "email")
	private String emailUsuario;

	@Column(name = "senha")
	private String senhaUsuario;
	
	@Column(name = "telefone")
	private String telefoneUsuario;

	public Usuario() {

	}

	public Usuario(int id, String nomeUsuario, String emailUsuario, String senhaUsuario,
			String telefoneUsuario) {
		super();
		this.id_usuario = id;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.telefoneUsuario = telefoneUsuario;
	}

	public int getId() {
		return id_usuario;
	}

	public void setId(int id) {
		this.id_usuario = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	
	
	

}