package com.pjalves.votenofilme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pjalves.votenofilme.dao.VotoDao;
import com.pjalves.votenofilme.entity.ResumoVotoDTO;
import com.pjalves.votenofilme.entity.Voto;

@Component
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoDao votoDao;
	
	public VotoServiceImpl() {
	}

	@Override
	public void registrar(List<Voto> votos) {
		for (Voto v : votos) {
			votoDao.create(v);
		}
	}
	
	@Override
	public List<Voto> findAll() {
		return votoDao.findAll();
	}
	
	public List<ResumoVotoDTO> resultadoVotos() {
		return votoDao.resultadoVotos();
	}

}
