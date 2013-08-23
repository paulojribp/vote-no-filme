package com.pjalves.votenofilme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.pjalves.votenofilme.entity.ResumoVotoDTO;
import com.pjalves.votenofilme.entity.Voto;

@Component
public class VotoDao {

	protected EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Voto> findAll() {
		return entityManager.createQuery("from Voto").getResultList();
	}
	
	public Voto find(Long id) {
		return entityManager.find(Voto.class, id);
	}

	public void create(Voto voto) {
		entityManager.persist(voto);
	}
	
	@SuppressWarnings("unchecked")
	public List<ResumoVotoDTO> resultadoVotos() {
		StringBuilder query = new StringBuilder();
		query.append(" select v.filme.nome, v.filme.path, sum(v.quantidade) ");
		query.append("   from Voto v ");
		query.append(" group by v.filme.nome, v.filme.path ");
		query.append(" order by sum(v.quantidade) desc ");
		
		Query q = entityManager.createQuery(query.toString());
		
		List<Object[]> res = q.getResultList();
		List<ResumoVotoDTO> resumo = new ArrayList<ResumoVotoDTO>();
		for (Object[] o : res) {
			resumo.add(new ResumoVotoDTO((String)o[0], (String)o[1], ((Long)o[2]).intValue()));
		}
		
		return resumo;
	}
	
}
