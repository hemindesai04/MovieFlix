package com.hemin.api.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hemin.api.entities.imdbRecord;

@Repository
public class AdminImdbRepositoryImpl implements AdminImdbRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public imdbRecord createRecord(imdbRecord record) {
		em.persist(record);
		return record;
	}

	@Override
	public imdbRecord updateRecord(imdbRecord record) {
		imdbRecord r = em.merge(record);
		return r;
	}

	@Override
	public void deleteRecord(imdbRecord record) {
		em.remove(record);
	}


}
