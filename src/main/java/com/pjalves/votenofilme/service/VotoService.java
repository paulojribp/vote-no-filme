package com.pjalves.votenofilme.service;

import java.util.List;

import com.pjalves.votenofilme.entity.ResumoVotoDTO;
import com.pjalves.votenofilme.entity.Voto;

public interface VotoService {

	void registrar(List<Voto> votos);

	List<Voto> findAll();

	List<ResumoVotoDTO> resultadoVotos();
	
}
