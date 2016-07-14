package com.hemin.api.repositories;

import java.util.List;

import com.hemin.api.entities.ActorMaster;
import com.hemin.api.entities.CountryMaster;
import com.hemin.api.entities.DirectorMaster;
import com.hemin.api.entities.GenreMaster;
import com.hemin.api.entities.LanguageMaster;
import com.hemin.api.entities.WriterMaster;
import com.hemin.api.entities.imdbRecord;

public interface imdbRepository {

	public List<imdbRecord> findAll();

	public imdbRecord findOne(String id);

	public imdbRecord findByTitle(String title);

	public ActorMaster findByActorName(String actorName);

	public CountryMaster findByCountryName(String countryName);

	public DirectorMaster findByDirectorName(String directorName);

	public WriterMaster findByWriterName(String writerName);

	public LanguageMaster findByLanguageName(String languageName);

	public GenreMaster findByGenreName(String genre);
	
}
