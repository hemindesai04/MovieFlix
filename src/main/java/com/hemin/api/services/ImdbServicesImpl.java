package com.hemin.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemin.api.conversion.ImdbRecordConversion;
import com.hemin.api.entities.imdbRecord;
import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.exceptions.EmptyRecords;
import com.hemin.api.exceptions.RecordNotFound;
import com.hemin.api.repositories.imdbRepository;

@Service
@Transactional
public class ImdbServicesImpl implements ImdbServices {
	
	@Autowired
	private imdbRepository repository;
	
	@Autowired
	private ImdbRecordConversion conversion;
	
	@Override
	public List<imdbRecordDTO> findAll() {
		List<imdbRecord> records = repository.findAll();
		List<imdbRecordDTO> newRecordList = new ArrayList<imdbRecordDTO>();
		if(records == null){
			try {
				throw new EmptyRecords("There are no records to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		}
		
		for (imdbRecord r : records) {
			newRecordList.add(conversion.entity2dto(r));
		}
		
		return newRecordList;
	}

	@Override
	public imdbRecordDTO findByTitle(String title) {
		imdbRecord existing = repository.findByTitle(title);
		if(existing == null){
			throw new RecordNotFound("Record with title = " + title + " not found.");
		}
		return conversion.entity2dto(existing);
	}

}
