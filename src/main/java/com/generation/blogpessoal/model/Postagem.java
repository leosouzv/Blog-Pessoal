package com.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//tabela postagem

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	// define o id como chave primária
	@Id
	// auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	// define que o campo não pode ser vazio
	@NotNull
	// define um número mínimo e máximo de caracteres
	@Size(min = 5, max = 250, message = "O campo deve ter no mínimo 5 caracteres, e no máximo 250 caracteres")
	public String texto;

	@NotNull
	@Size(max = 40, message = "O campo deve possuir 40 caracteres no máximo")
	public String titulo;
	
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
