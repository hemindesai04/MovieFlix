package com.hemin.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemin.api.conversion.ImdbRecordConversion;
import com.hemin.api.entities.imdbRecord;
import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.exceptions.RecordAlreadyExist;
import com.hemin.api.exceptions.RecordNotFound;
import com.hemin.api.repositories.AdminImdbRepository;
import com.hemin.api.repositories.imdbRepository;

@Service
@Transactional
public class AdminImdbServicesImpl implements AdminImdbServices {
	
	@Autowired
	private imdbRepository repository;
	
	@Autowired
	private AdminImdbRepository adminRepository;
	
	@Autowired
	private ImdbRecordConversion conversion;
	
	// Create, Update and Delete imdb records for admin
	
	@Override
	public List<imdbRecordDTO> createRecord(List<imdbRecordDTO> listRecord) {
		List<imdbRecord> list = new ArrayList<imdbRecord>();
		List<imdbRecordDTO> listDTO = new ArrayList<imdbRecordDTO>();
		
		// for loop to convert the list of dto objects to list entity objects
		for (imdbRecordDTO r : listRecord) {
			//list.add(dto2entity(r));
			imdbRecord rd = conversion.dto2entity(r);
			if(repository.findByTitle(rd.getTitle()) != null){
				throw new RecordAlreadyExist("Record with title = " + rd.getTitle() + "already exist." );
			} else{
				list.add(adminRepository.createRecord(rd));
			}
		}	
		// for loop to convert the list of entity objects to list of dto objects
		for (imdbRecord r : list) {
			listDTO.add(conversion.entity2dto(r));
		}
		return listDTO;
		
	}

	@Override
	public imdbRecordDTO updateRecord(String id, imdbRecordDTO record) {
		imdbRecord existing = repository.findOne(id);
		imdbRecord upRecord = conversion.dto2entity(record);
		if(existing == null){
			throw new RecordNotFound("Record with id = " + id + "not found.");
		}else{
			upRecord.setId(id);
		}
		return conversion.entity2dto(adminRepository.updateRecord(upRecord));
	}

	@Override
	public void deleteRecord(String id) {
		imdbRecord existing = repository.findOne(id);
		if(existing == null){
			throw new RecordNotFound("Record with id = " + id + "not found.");
		}
		adminRepository.deleteRecord(existing);
	}
}
