/****************************************************************************************************
 * 		:<Rest Controller for Admin>: - (/MovieFlix-0.0.1/api/admin/records)					   	*
 * Methods include: 1. createRecord - (POST) Add multiple titles (also includes single title)		*
 * 					2. updateRecord - (PUT - /{id})Edit a record with the specific "id"				*								   *
 * 					3. deleteRecord - (DELETE - /{id}) Delete a record with the specific "id"		* 								   *
 * 					4. findAll 		- (GET) Return all records from the database			   		*
 * 					5. findByTitle	- (GET - /{title})Returns a record with the specific "title"	*
 ****************************************************************************************************/

package com.hemin.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.services.AdminImdbServices;
import com.hemin.api.services.ImdbServices;

@RestController
@RequestMapping("/admin/records/")
public class AdminImdbController {
	
	@Autowired
	private ImdbServices service;
	
	@Autowired
	private AdminImdbServices adminService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public imdbRecordDTO findByTitle(@PathVariable("title") String recordTitle){
		return service.findByTitle(recordTitle);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> createRecord(@RequestBody List<imdbRecordDTO> record){
		return adminService.createRecord(record);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public imdbRecordDTO updateRecord(@PathVariable("id") String recordId, @RequestBody imdbRecordDTO record){
		return adminService.updateRecord(recordId, record);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteRecord(@PathVariable("id") String recordId){
		adminService.deleteRecord(recordId);
	}
	
	
	
}
