package com.hemin.api.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hemin.api.entities.CommentMaster;
import com.hemin.api.entities.CommentMasterDTO;
import com.hemin.api.repositories.UserImdbRepository;
import com.hemin.api.repositories.imdbRepository;

@Component
public class CommentMasterConversionImpl implements CommentMasterConversion{

	@Autowired
	private UserImdbRepository userRepository;
	
	@Autowired
	private imdbRepository repository;
	
	@Override
	public CommentMasterDTO entity2dto(CommentMaster cm) {
		CommentMasterDTO cmDTO = new CommentMasterDTO();
		
		cmDTO.setComment(cm.getComment());
		
		cmDTO.setMovie(cm.getRecord().getTitle());
		
		cmDTO.setUserID(cm.getUser().getFirstName());
		
		return cmDTO;
	}

	@Override
	public CommentMaster dto2entity(CommentMasterDTO cmDTO) {
		CommentMaster cm = new CommentMaster();
		
		cm.setComment(cmDTO.getComment());
		
		cm.setRecord(repository.findByTitle(cmDTO.getMovie()));
		
		cm.setUser(userRepository.findUserByID(cmDTO.getUserID()));
		
		return cm;
	}

}
