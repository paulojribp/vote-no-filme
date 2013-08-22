package com.pjalves.votenofilme.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private String path;

	public Filme() {
	}
	
	public Filme(Long id, String nome, String descricao, String path) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.path = path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
