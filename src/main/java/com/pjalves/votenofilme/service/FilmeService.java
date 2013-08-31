package com.pjalves.votenofilme.service;

import java.util.List;

import com.pjalves.votenofilme.entity.Filme;

public interface FilmeService {

	/**
	 * Retorna todos os filmes cadastrados
	 * 
	 * @return Lista de Filmes
	 */
	List<Filme> findAll();
	
	/**
	 * Cria os filmes ao subir a aplicação caso ainda não existam na base
	 * 
	 * @return List de Filmes criados
	 */
	List<Filme> criarFilmesPadrao();
	
}
