package com.hemin.api.conversion;

import com.hemin.api.entities.CommentMaster;
import com.hemin.api.entities.CommentMasterDTO;

public interface CommentMasterConversion {
	
	public CommentMasterDTO entity2dto(CommentMaster cm);
	
	public CommentMaster dto2entity(CommentMasterDTO cmDTO);

}
