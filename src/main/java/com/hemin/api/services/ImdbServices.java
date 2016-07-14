package com.hemin.api.services;

import java.util.List;

import com.hemin.api.entities.imdbRecordDTO;

public interface ImdbServices {

	public List<imdbRecordDTO> findAll();
	
	public imdbRecordDTO findByTitle(String id);
	
}
