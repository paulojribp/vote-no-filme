package com.pjalves.votenofilme.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppStartupService {

	@Autowired(required=true)
	private FilmeService filmeService;
	
	@PostConstruct
	public void initialize() {
		filmeService.criarFilmesPadrao();
	}
	
}
