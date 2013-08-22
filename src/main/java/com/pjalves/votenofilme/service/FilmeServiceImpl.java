package com.pjalves.votenofilme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pjalves.votenofilme.dao.FilmeDao;
import com.pjalves.votenofilme.entity.Filme;

@Component
public class FilmeServiceImpl implements FilmeService {

	@Autowired
	private FilmeDao filmeDao;
	
	public FilmeServiceImpl() {
	}

	@Override
	public void create(Filme filme) {
		filmeDao.create(filme);
	}

	@Override
	public void update(Filme filme) {
		Filme f2 = find(filme.getId());
		f2.setNome(filme.getNome());
		f2.setDescricao(filme.getDescricao());
		f2.setPath(filme.getPath());
		filmeDao.update(f2);
	}

	@Override
	public void remove(Long id) {
		filmeDao.remove(id);
	}

	@Override
	public List<Filme> findAll() {
		return filmeDao.findAll();
	}

	@Override
	public Filme find(Long id) {
		return filmeDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void criarFilmesPadrao() {
		List<Filme> filmes = new ArrayList<Filme>();
		if (filmeDao.find(1l) == null) {
			filmes.add( new Filme(1l, "Matrix", "Entre no mundo da Matrix", "images/filme-matrix.jpg") );
		}
		
		if (filmeDao.find(2l) == null) {
			filmes.add( new Filme(2l, "Terminator", 
					"Um cyborg volta ao passado para elimitar o futuro líder de uma revolução", "images/filme-terminator.jpg") );
		}
		
		if (filmeDao.find(3l) == null) {
			filmes.add( new Filme(3l, "RED", "Grupo de ex-agentes aposentados entram em ação", "images/filme-red.jpg") );
		}
		
		if (filmeDao.find(4l) == null) {
			filmes.add( new Filme(4l, "Star Trek", 
					"Uma mega nave e um famoso capitão - a USS Enterprise e Kirk uma dupla inserparável", "images/filme-startrek.jpg") );
		}
		
		if (filmeDao.find(5l) == null) {
			filmes.add( new Filme(5l, "Toy Story", "Brinquedos que se mexem para assustar criançinhas indefesas", "images/filme-toystory.jpg") );
		}
		filmeDao.create(filmes);
	}
}
