package com.pjalves.votenofilme.service;

import java.util.List;

import com.pjalves.votenofilme.entity.Filme;
import com.pjalves.votenofilme.entity.Voto;

public interface FilmeService {

	void update(Filme filme);

	void remove(Long id);

	List<Filme> findAll();
	
	Filme find(Long id);

	List<Filme> criarFilmesPadrao();
	
}
