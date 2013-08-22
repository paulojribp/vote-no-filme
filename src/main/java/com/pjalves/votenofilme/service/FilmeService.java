package com.pjalves.votenofilme.service;

import java.util.List;

import com.pjalves.votenofilme.entity.Filme;

public interface FilmeService {

	void create(Filme fabricante);

	void update(Filme fabricante);

	void remove(Long id);

	List<Filme> findAll();
	
	Filme find(Long id);

	List<Filme> criarFilmesPadrao();
	
}
