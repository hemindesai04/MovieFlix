package com.hemin.api.conversion;

import com.hemin.api.entities.imdbRecord;
import com.hemin.api.entities.imdbRecordDTO;

public interface ImdbRecordConversion {

	public imdbRecord dto2entity(imdbRecordDTO record);
	
	public imdbRecordDTO entity2dto(imdbRecord record);
	
}
