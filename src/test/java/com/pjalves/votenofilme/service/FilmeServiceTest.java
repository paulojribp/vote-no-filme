package com.pjalves.votenofilme.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pjalves.votenofilme.dao.FilmeDao;
import com.pjalves.votenofilme.entity.Filme;

@RunWith(MockitoJUnitRunner.class)
public class FilmeServiceTest {

	@InjectMocks
	private FilmeServiceImpl filmeService = new FilmeServiceImpl();
	
	@Mock
	private FilmeDao filmeDao;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void criarFilmesPadraoNenhumFilmeCriado() {
		Mockito.when(filmeDao.find(1l)).thenReturn(null);
		Mockito.when(filmeDao.find(2l)).thenReturn(null);
		Mockito.when(filmeDao.find(3l)).thenReturn(null);
		Mockito.when(filmeDao.find(4l)).thenReturn(null);
		Mockito.when(filmeDao.find(5l)).thenReturn(null);
		
		List<Filme> filmes = filmeService.criarFilmesPadrao();
		
		assertEquals(filmes.size(), 5);
	}
	
	@Test
	public void criarFilmesPadraoAlgunsFilmesCriados() {
		Mockito.when(filmeDao.find(1l)).thenReturn(getFilme1());
		Mockito.when(filmeDao.find(2l)).thenReturn(null);
		Mockito.when(filmeDao.find(3l)).thenReturn(getFilme3());
		Mockito.when(filmeDao.find(4l)).thenReturn(null);
		Mockito.when(filmeDao.find(5l)).thenReturn(getFilme5());
		
		List<Filme> filmes = filmeService.criarFilmesPadrao();
		
		assertEquals(filmes.size(), 2);
	}
	
	@Test
	public void criarFilmesPadraoTodosFilmesCriados() {
		Mockito.when(filmeDao.find(1l)).thenReturn(getFilme1());
		Mockito.when(filmeDao.find(2l)).thenReturn(getFilme2());
		Mockito.when(filmeDao.find(3l)).thenReturn(getFilme3());
		Mockito.when(filmeDao.find(4l)).thenReturn(getFilme4());
		Mockito.when(filmeDao.find(5l)).thenReturn(getFilme5());
		
		List<Filme> filmes = filmeService.criarFilmesPadrao();
		
		assertTrue(filmes.isEmpty());
	}
	
	private Filme getFilme1() {
		return new Filme(1l, "Matrix", "Entre no mundo da Matrix", "images/filme-matrix.jpg");
	}
	private Filme getFilme2() {
		return new Filme(2l, "Terminator", 
				"Um cyborg volta ao passado para elimitar o futuro líder de uma revolução", "images/filme-terminator.jpg");
	}
	private Filme getFilme3() {
		return new Filme(3l, "RED", "Grupo de ex-agentes aposentados entram em ação", "images/filme-red.jpg");
	}
	private Filme getFilme4() {
		return new Filme(4l, "Star Trek", 
				"Uma mega nave e um famoso capitão - a USS Enterprise e Kirk uma dupla inserparável", "images/filme-startrek.jpg");
	}
	private Filme getFilme5() {
		return new Filme(5l, "Toy Story", "Brinquedos que se mexem para assustar criançinhas indefesas", "images/filme-toystory.jpg");
	}

}
