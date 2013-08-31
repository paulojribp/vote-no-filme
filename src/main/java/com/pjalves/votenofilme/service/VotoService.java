package com.pjalves.votenofilme.service;

import java.util.List;

import com.pjalves.votenofilme.entity.ResumoVotoDTO;
import com.pjalves.votenofilme.entity.Voto;

public interface VotoService {

	/**
	 * Registra os votos selecionados dos filmes escolhidos
	 * 
	 * @param votos
	 */
	void registrar(List<Voto> votos);

	/**
	 * Lista todos os votos já registrados
	 * @return
	 */
	List<Voto> findAll();

	/**
	 * Retorna o resumo do resultado dos votos com os respectivos filmes
	 * 
	 * @return List de Resumos
	 */
	List<ResumoVotoDTO> resultadoVotos();
	
}
