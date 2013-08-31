package com.pjalves.votenofilme.action;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.pjalves.votenofilme.entity.Filme;
import com.pjalves.votenofilme.entity.ResumoVotoDTO;
import com.pjalves.votenofilme.entity.Voto;
import com.pjalves.votenofilme.service.FilmeService;
import com.pjalves.votenofilme.service.VotoService;

@Resource
@Path("/filme")
public class FilmeController {

	private Result result;
	private FilmeService filmeService;
	private VotoService votoService;
	
	public FilmeController(Result result, FilmeService filmeService, VotoService votoService) {
		this.result = result;
		this.filmeService = filmeService;
		this.votoService = votoService;
	}
	
	@Get("/")
	public void index() {
		// void method to redirect /WEB-INF/jsp/filme/index.jsp
	}
	
	@Post("/registrar")
	public void registrar(List<Voto> votos) {
		votoService.registrar(votos);
		result.use(Results.json()).from("success").serialize();
	}
	
	@Get("/list")
	public void list() {
		List<Filme> filmes = filmeService.findAll();
		result.use(Results.json()).from(filmes).serialize();
	}
	
	@Get("/listVotos")
	public void listVotos() {
		List<Voto> votos = votoService.findAll();
		result.use(Results.json()).from(votos).serialize();
	}
	
	@Get("/resultadoVotos")
	public void resultadoVotos() {
		List<ResumoVotoDTO> resumo = votoService.resultadoVotos();
		result.use(Results.json()).from(resumo).serialize();
	}
	
}
