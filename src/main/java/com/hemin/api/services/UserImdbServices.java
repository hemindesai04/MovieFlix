package com.hemin.api.services;

import java.util.List;

import com.hemin.api.entities.CommentMasterDTO;
import com.hemin.api.entities.RatingMasterDTO;
import com.hemin.api.entities.User;
import com.hemin.api.entities.imdbRecordDTO;

public interface UserImdbServices {

	List<imdbRecordDTO> findAllMovies();

	List<imdbRecordDTO> findAllTvSeries();

	List<imdbRecordDTO> sortByImdbRatings();

	List<imdbRecordDTO> sortByImdbVotes();

	List<imdbRecordDTO> sortByYear();

	List<imdbRecordDTO> filterByYear(String year);

	List<imdbRecordDTO> filterByGenre(String genre);

	List<imdbRecordDTO> filterByActor(String actor);

	User createUser(User user);

	CommentMasterDTO addComment(CommentMasterDTO cmDTO);

	RatingMasterDTO addRating(RatingMasterDTO rating);

	List<CommentMasterDTO> viewComments(String title);

	List<imdbRecordDTO> viewTopRated();

	int averageRating(String title);

	

}
