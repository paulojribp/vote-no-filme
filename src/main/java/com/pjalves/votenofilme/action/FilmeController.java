package com.pjalves.votenofilme.action;

import java.util.List;

import com.pjalves.votenofilme.entity.Filme;
import com.pjalves.votenofilme.service.FilmeService;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/filme")
public class FilmeController {

	private Result result;
	private FilmeService filmeService;
	
	public FilmeController(Result result, FilmeService filmeService) {
		this.result = result;
		this.filmeService = filmeService;
	}
	
	@Get("/")
	public void index() {
		// void method to redirect /WEB-INF/jsp/filme/index.jsp
	}
	
	@Post("/create")
	public void create(Filme filme) {
		try {
			filmeService.create(filme);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Post("/update")
	public void update(Filme filme) {
		try {
			filmeService.update(filme);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Post("/remove")
	public void remove(Long id) {
		try {
			filmeService.remove(id);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Get("/list")
	public void list() {
		try {
			List<Filme> filmes = filmeService.findAll();
			result.use(Results.json()).from(filmes).serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
}
