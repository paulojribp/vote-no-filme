package com.pjalves.votenofilme.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Voto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FILME_SEQ")
	@SequenceGenerator(name="FILME_SEQ", sequenceName="FILME_SEQ", allocationSize=1)
	private Long id;
	
	private String nome;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "filmeid")
	private Filme filme;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
