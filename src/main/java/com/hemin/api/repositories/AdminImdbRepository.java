package com.hemin.api.repositories;

import com.hemin.api.entities.imdbRecord;

public interface AdminImdbRepository {
	
	public imdbRecord createRecord(imdbRecord record);

	public imdbRecord updateRecord(imdbRecord record);

	void deleteRecord(imdbRecord record);

}
