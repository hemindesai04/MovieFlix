package com.hemin.api.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hemin.api.entities.ActorMaster;
import com.hemin.api.entities.CountryMaster;
import com.hemin.api.entities.DirectorMaster;
import com.hemin.api.entities.GenreMaster;
import com.hemin.api.entities.LanguageMaster;
import com.hemin.api.entities.WriterMaster;
import com.hemin.api.entities.imdbRecord;

@Repository
public class imdbRespositoryImpl implements imdbRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<imdbRecord> findAll() {
		TypedQuery<imdbRecord> query = em.createQuery("from imdbRecord", imdbRecord.class);
		return query.getResultList();
	}

	@Override
	public imdbRecord findOne(String id) {
		return em.find(imdbRecord.class, id);
	}

	@Override
	public imdbRecord findByTitle(String title) {
		TypedQuery<imdbRecord> query = em.createNamedQuery("imdbRecord.findByTitle", imdbRecord.class);
		query.setParameter("pTitle", title);
		List<imdbRecord> records = query.getResultList();
		if(records != null && records.size() == 1){
			return records.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public GenreMaster findByGenreName(String genre) {
		TypedQuery<GenreMaster> query = em.createNamedQuery("GenreMaster.findByGenreName", GenreMaster.class);
		//TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r JOIN r.genre g WHERE g.genreName=:pGenre", imdbRecord.class);
		query.setParameter("pgenreName", genre);
		List<GenreMaster> genreRecords = query.getResultList();
		if(genreRecords != null && genreRecords.size() == 1)
			return genreRecords.get(0);
		else
			return null;
	}

	@Override
	public ActorMaster findByActorName(String actorName) {
		TypedQuery<ActorMaster> query = em.createNamedQuery("ActorMaster.findByActorName", ActorMaster.class);
		query.setParameter("pactorName", actorName);
		List<ActorMaster> actorRecords = query.getResultList();
		if(actorRecords != null && actorRecords.size() == 1)
			return actorRecords.get(0);
		else
			return null;
	}
	
	@Override
	public CountryMaster findByCountryName(String countryName) {
		TypedQuery<CountryMaster> query = em.createNamedQuery("CountryMaster.findByCountryName", CountryMaster.class);
		query.setParameter("pcountryName", countryName);
		List<CountryMaster> countryRecords = query.getResultList();
		if(countryRecords != null && countryRecords.size() == 1)
			return countryRecords.get(0);
		else
			return null;
	}

	@Override
	public DirectorMaster findByDirectorName(String directorName) {
		TypedQuery<DirectorMaster> query = em.createNamedQuery("DirectorMaster.findByDirectorName", DirectorMaster.class);
		query.setParameter("pdirectorName", directorName);
		List<DirectorMaster> directorRecords = query.getResultList();
		if(directorRecords != null && directorRecords.size() == 1)
			return directorRecords.get(0);
		else
			return null;
	}

	@Override
	public WriterMaster findByWriterName(String writerName) {
		TypedQuery<WriterMaster> query = em.createNamedQuery("WriterMaster.findByWriterName", WriterMaster.class);
		query.setParameter("pwriterName", writerName);
		List<WriterMaster> writerRecords = query.getResultList();
		if(writerRecords != null && writerRecords.size() == 1)
			return writerRecords.get(0);
		else
			return null;
	}

	@Override
	public LanguageMaster findByLanguageName(String languageName) {
		TypedQuery<LanguageMaster> query = em.createNamedQuery("LanguageMaster.findByLanguageName", LanguageMaster.class);
		query.setParameter("plang", languageName);
		List<LanguageMaster> languageRecords = query.getResultList(); 
		if(languageRecords != null && languageRecords.size() == 1)
			return languageRecords.get(0);
		else
			return null;
	}

}
