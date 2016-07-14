package com.hemin.api.conversion;

import com.hemin.api.entities.RatingMaster;
import com.hemin.api.entities.RatingMasterDTO;

public interface RatingMasterConversion {
	
	public RatingMaster dto2entity(RatingMasterDTO rmDTO);
	
	public RatingMasterDTO entity2dto(RatingMaster rm);

}
