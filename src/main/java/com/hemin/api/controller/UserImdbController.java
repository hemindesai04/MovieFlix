/********************************************************************************************************************************
 *				:<UserImdbController>: - (/MovieFlix-0.0.1/api/user/)															*	 
 * 	Methods: 1. findAll() - (GET - /records)returns all the movies and TV series			  									*
 * 			 2. findByTitle - (GET - /records/{title}) returns the record with the specific "title" 							*
 * 			 3. findAllMovies - (GET - /records/movies) return records which are only of type movie 							*
 * 			 4. findAllTvSeries - (GET - /records/tvseries) return records which are only of type series						*
 * 			 5. sortByImdbRatings - (GET - /records/imdbRatings) return all the records with descending order of imdbRatings	*
 * 			 6. sortByImdbVotes - (GET - /records/imdbVotes) return all the records with descending order of imdbVotes 			*
 * 			 7. sortByYear - (GET - /records/year) return all the records with latest first										*
 * 			 8. filterByYear - (GET - /records/year/{year}) return all the records of that specific "year"						*
 * 			 9. filterByActor - (GET - /records/actor/{actor}) return all the records of that specific "actor"					*
 * 			10. filterByGenre - (GET - /records/genre/{genre}) return all the records of that specific "genre"					*
 * 			11. addComment - (POST - /records/comment) adds a comment for the specific title by the specific user				*
 * 			12. viewComments - (GET - /records/comment/{title}) return all the comments of that specific "title"				*
 * 			13. addRating - (POST - /records/rating) adds a rating for the spcific title by the specific user					*
 * 			14. viewTopRated - (GET - /records/rating/topRated) return all the records with the highest ratings first			*
 * 			15. averageRating - (GET - /records/rating/{title}) returns average rating given by users to the specific "title"	*
 ********************************************************************************************************************************/


package com.hemin.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemin.api.entities.CommentMasterDTO;
import com.hemin.api.entities.RatingMasterDTO;
import com.hemin.api.entities.User;
import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.services.ImdbServices;
import com.hemin.api.services.UserImdbServices;


@RestController
@RequestMapping("/user/")
public class UserImdbController {
	
	@Autowired
	private ImdbServices service;
	
	@Autowired
	private UserImdbServices userImdbservice;
	
	// return all imdbRecords (movies + tv series)
	@RequestMapping(method = RequestMethod.GET, value = "/records", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> findAll(){
		return service.findAll();
	}
	
	// return specific record with the same title as passed
	@RequestMapping(method = RequestMethod.GET, value = "/records/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public imdbRecordDTO findByTitle(@PathVariable("title") String recordTitle){
		return service.findByTitle(recordTitle);
	}
	
	// method for both filter movies and browse category
	@RequestMapping(method = RequestMethod.GET, value = "/records/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> findAllMovies(){
		return userImdbservice.findAllMovies();
	}
	
	// method for both filter tv servies and browse category
	@RequestMapping(method = RequestMethod.GET, value = "/records/tvseries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> findAllTvSeries(){
		return userImdbservice.findAllTvSeries();
	}
	
	// return all (tv series + movies) with descending order of imdbRatings
	@RequestMapping(method = RequestMethod.GET, value = "/records/imdbRatings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> sortByImdbRatings(){
		return userImdbservice.sortByImdbRatings();
	}
	
	// return all (tv series + movies) with decreasing order of imdbVotes
	@RequestMapping(method = RequestMethod.GET, value = "/records/imdbVotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> sortByImdbVotes(){
		return userImdbservice.sortByImdbVotes();
	}
	
	// return all (tv series + movies) with latest records first
	@RequestMapping(method = RequestMethod.GET, value = "/records/year", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> sortByYear(){
		return userImdbservice.sortByYear();
	}
	
	// return all (tv series + movies) of the specific year passed
	@RequestMapping(method = RequestMethod.GET, value = "/records/year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> filterByYear(@PathVariable("year") String year){
		return userImdbservice.filterByYear(year);
	}
	
	// return all (tv series + movies) of the specific genre passed
	@RequestMapping(method = RequestMethod.GET, value = "/records/genre/{genre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> filterByGenre(@PathVariable("genre") String genre){
		return userImdbservice.filterByGenre(genre);
	}
	
	// return all (tv series + movies) of the specific actor passed
	@RequestMapping(method = RequestMethod.GET, value = "/records/actor/{actor}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> filterByActor(@PathVariable("actor") String actor){
		return userImdbservice.filterByActor(actor);
	}
	
	// method which returns all (tv series + movies) of the specific language passed
	// method which returns all (tv series + movies) of the specific country passed
	// method which returns all (tv series + movies) of the specific director passed
	// method which returns all (tv series + movies) of the specific writer passed
	
	// method to add comments by a user on a specific title
	@RequestMapping(method = RequestMethod.POST, value = "/records/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommentMasterDTO addComment(@RequestBody CommentMasterDTO comment){
		return userImdbservice.addComment(comment);
	}
	
	// method to view comments of a particular title
	@RequestMapping(method = RequestMethod.GET, value = "/records/comment/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentMasterDTO> displayComments(@PathVariable("title") String title){
		return userImdbservice.viewComments(title);
	}
	
	// method to add rating out of 5 by a user on a specific title
	@RequestMapping(method = RequestMethod.POST, value = "/records/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RatingMasterDTO addRating(@RequestBody RatingMasterDTO rating){
		return userImdbservice.addRating(rating);
	}
	
	// method to view top rated movies and tv series
	@RequestMapping(method = RequestMethod.GET, value = "/records/rating/topRated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<imdbRecordDTO> viewTopRated(){
		return userImdbservice.viewTopRated();
	}
	
	// method to view average ratings of a movie or tv series
	@RequestMapping(method = RequestMethod.GET, value = "/records/rating/{title}", produces = {"APPLICATION/JSON"})
	public int averageRating(@PathVariable("title") String title){
		return userImdbservice.averageRating(title);
	}
	
	// method to create user
	@RequestMapping(method = RequestMethod.POST, value = "/createUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User addUser(@RequestBody User user){
		return userImdbservice.createUser(user);
	}
	
}