package com.hemin.api.repositories;

import java.util.List;

import com.hemin.api.entities.CommentMaster;
import com.hemin.api.entities.RatingMaster;
import com.hemin.api.entities.User;
import com.hemin.api.entities.imdbRecord;

public interface UserImdbRepository {

	List<imdbRecord> findAllMovies();

	List<imdbRecord> findAllTvSeries();

	List<imdbRecord> sortByImdbRatings();

	List<imdbRecord> sortByImdbVotes();

	List<imdbRecord> sortByYear();

	List<imdbRecord> filterByYear(String year);

	User findUserByID(String user_id);

	CommentMaster addComment(CommentMaster cm);

	User createUser(User user);

	RatingMaster addRating(RatingMaster dto2entity);

	List<RatingMaster> viewTopRated();

}
