package com.pjalves.votenofilme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.pjalves.votenofilme.entity.Filme;

@Component
public class FilmeDao {

	protected EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> findAll() {
		return entityManager.createQuery("from Filme").getResultList();
	}
	
	public Filme find(Long id) {
		return entityManager.find(Filme.class, id);
	}

	public void create(Filme filme) {
		entityManager.persist(filme);
	}
	
	public void create(List<Filme> filmes) {
		if (filmes != null && !filmes.isEmpty()) {
			for (Filme f : filmes) {
				entityManager.persist(f);
			}
		}
	}

	public void remove(Long id) {
		Filme f = find(id);
		entityManager.remove(f);
	}

	public void update(Filme filme) {
		entityManager.merge(filme);
	}
	
	
	
}
