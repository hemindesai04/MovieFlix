package com.hemin.api.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hemin.api.entities.RatingMaster;
import com.hemin.api.entities.RatingMasterDTO;
import com.hemin.api.repositories.UserImdbRepository;
import com.hemin.api.repositories.imdbRepository;

@Component
public class RatingMasterConversionImpl implements RatingMasterConversion {

	@Autowired
	private imdbRepository repository;
	
	@Autowired
	private UserImdbRepository userRepository;
	
	@Override
	public RatingMaster dto2entity(RatingMasterDTO rmDTO) {
		RatingMaster rm = new RatingMaster();
		
		rm.setStar(Integer.valueOf(rmDTO.getStar()));
		
		rm.setRecord(repository.findByTitle(rmDTO.getTitle()));
		
		rm.setUser(userRepository.findUserByID(rmDTO.getUserid()));
		
		return rm;
	}

	@Override
	public RatingMasterDTO entity2dto(RatingMaster rm) {
		RatingMasterDTO rmDTO = new RatingMasterDTO();
		
		rmDTO.setStar(String.valueOf(rm.getStar()));
		
		rmDTO.setTitle(rm.getRecord().getTitle());
		
		rmDTO.setUserid(rm.getUser().getFirstName());
		
		return rmDTO;
	}

}
