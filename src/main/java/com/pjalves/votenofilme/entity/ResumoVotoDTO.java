package com.pjalves.votenofilme.entity;

public class ResumoVotoDTO {

	private String nome;
	
	private String path;
	
	private Integer quantidadeVotos;

	public ResumoVotoDTO() {
	}

	public ResumoVotoDTO(String nome, String path, Integer quantidadeVotos) {
		this.nome = nome;
		this.path = path;
		this.quantidadeVotos = quantidadeVotos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
}
