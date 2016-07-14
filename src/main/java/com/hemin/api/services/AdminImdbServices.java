package com.hemin.api.services;

import java.util.List;

import com.hemin.api.entities.imdbRecordDTO;

public interface AdminImdbServices {
	
	public List<imdbRecordDTO> createRecord(List<imdbRecordDTO> record);
	
	public imdbRecordDTO updateRecord(String recordId, imdbRecordDTO record);
	
	public void deleteRecord(String id);
	
}
