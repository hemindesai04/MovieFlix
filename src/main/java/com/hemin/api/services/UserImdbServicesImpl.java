package com.hemin.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemin.api.conversion.CommentMasterConversion;
import com.hemin.api.conversion.ImdbRecordConversion;
import com.hemin.api.conversion.RatingMasterConversion;
import com.hemin.api.entities.ActorMaster;
import com.hemin.api.entities.CommentMaster;
import com.hemin.api.entities.CommentMasterDTO;
import com.hemin.api.entities.GenreMaster;
import com.hemin.api.entities.RatingMaster;
import com.hemin.api.entities.RatingMasterDTO;
import com.hemin.api.entities.User;
import com.hemin.api.entities.imdbRecord;
import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.exceptions.EmptyRecords;
import com.hemin.api.repositories.UserImdbRepository;
import com.hemin.api.repositories.imdbRepository;

@Service
@Transactional
public class UserImdbServicesImpl implements UserImdbServices {

	@Autowired
	private UserImdbRepository userRepository;
	
	@Autowired 
	private imdbRepository repository;
	
	@Autowired
	private ImdbRecordConversion conversion;
	
	@Autowired
	private CommentMasterConversion commentConversion;
	
	@Autowired
	private RatingMasterConversion ratingConversion;
	
	@Override
	public List<imdbRecordDTO> findAllMovies() {	
		List<imdbRecord> movieRecords = userRepository.findAllMovies();
		List<imdbRecordDTO> movieRecordsDTO = null;
		if(movieRecords == null || movieRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no movies to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			for (imdbRecord r : movieRecords) {
				if(movieRecordsDTO == null)
					movieRecordsDTO = new ArrayList<imdbRecordDTO>();
				movieRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return movieRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> findAllTvSeries() {
		List<imdbRecord> tvseriesRecords = userRepository.findAllTvSeries();
		List<imdbRecordDTO> tvseriesRecordsDTO = null;
		if(tvseriesRecords == null || tvseriesRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no TV Series to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		}
		else{
			for(imdbRecord r : tvseriesRecords){
				if(tvseriesRecordsDTO == null)
					tvseriesRecordsDTO = new ArrayList<imdbRecordDTO>();
				tvseriesRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return tvseriesRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> sortByImdbRatings() {
		List<imdbRecord> sortRatingRecords = userRepository.sortByImdbRatings();
		List<imdbRecordDTO> sortRatingRecordsDTO = null;
		if(sortRatingRecords == null || sortRatingRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no imdbRecords to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			for (imdbRecord r : sortRatingRecords) {
				if(sortRatingRecordsDTO == null)
					sortRatingRecordsDTO = new ArrayList<imdbRecordDTO>();
				sortRatingRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return sortRatingRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> sortByImdbVotes() {
		List<imdbRecord> sortVoteRecords = userRepository.sortByImdbVotes();
		List<imdbRecordDTO> sortVoteRecordsDTO = null;
		if(sortVoteRecords == null || sortVoteRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no Movies or TV Series to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			for (imdbRecord r : sortVoteRecords) {
				if(sortVoteRecordsDTO == null)
					sortVoteRecordsDTO = new ArrayList<imdbRecordDTO>();
				sortVoteRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return sortVoteRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> sortByYear() {
		List<imdbRecord> sortByYearRecords = userRepository.sortByYear();
		List<imdbRecordDTO> sortByYearRecordsDTO = null;
		if(sortByYearRecords == null || sortByYearRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no Movies or TV Series to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			for (imdbRecord r : sortByYearRecords) {
				if(sortByYearRecordsDTO == null)
					sortByYearRecordsDTO = new ArrayList<imdbRecordDTO>();
				sortByYearRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return sortByYearRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> filterByYear(String year) {
		List<imdbRecord> filterByYearRecords = userRepository.filterByYear(year);
		List<imdbRecordDTO> filterByYearRecordsDTO = null;
		if(filterByYearRecords == null || filterByYearRecords.isEmpty()){
			try {
				throw new EmptyRecords("There are no Movies or TV Series during "+year+" to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			for (imdbRecord r : filterByYearRecords) {
				if(filterByYearRecordsDTO == null)
					filterByYearRecordsDTO = new ArrayList<imdbRecordDTO>();
				filterByYearRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return filterByYearRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> filterByGenre(String genre) {
		GenreMaster filterByGenreRecord = repository.findByGenreName(genre);
		List<imdbRecordDTO> filterByGenreRecordsDTO = null;
		List<imdbRecord> finalRecords = null;
		if(filterByGenreRecord == null){
			try {
				throw new EmptyRecords("There are no Movies or TV Series of Genre Type "+genre+" to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else {
			if(finalRecords == null)
				finalRecords = new ArrayList<imdbRecord>();
			finalRecords.addAll(filterByGenreRecord.getRecords());
			for (imdbRecord r : finalRecords) {
				if(filterByGenreRecordsDTO == null)
					filterByGenreRecordsDTO = new ArrayList<imdbRecordDTO>();
				filterByGenreRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return filterByGenreRecordsDTO;
	}

	@Override
	public List<imdbRecordDTO> filterByActor(String actor) {
		ActorMaster filterByActorRecord = repository.findByActorName(actor);
		List<imdbRecordDTO> filterByActorRecordsDTO = null;
		List<imdbRecord> finalRecords = null;
		if(filterByActorRecord == null){
			try {
				throw new EmptyRecords("There are no Movies or TV Series of "+actor+" to show.");
			} catch (EmptyRecords e) {
				e.printStackTrace();
			}
		} else{
			if(finalRecords == null)
				finalRecords = new ArrayList<imdbRecord>();
			finalRecords.addAll(filterByActorRecord.getRecords());
			for (imdbRecord r : finalRecords) {
				if(filterByActorRecordsDTO == null)
					filterByActorRecordsDTO = new ArrayList<imdbRecordDTO>();
				filterByActorRecordsDTO.add(conversion.entity2dto(r));
			}
		}
		return filterByActorRecordsDTO;
	}

	@Override
	public CommentMasterDTO addComment(CommentMasterDTO cmDTO) {
		CommentMaster cm = userRepository.addComment(commentConversion.dto2entity(cmDTO));
		return commentConversion.entity2dto(cm);
	}

	@Override
	public List<CommentMasterDTO> viewComments(String title) {
		imdbRecord titleRecord = repository.findByTitle(title);
		if(titleRecord == null){
			try {
				throw new EmptyRecords("There are no Movies or TV Series with title "+title+" to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		List<CommentMasterDTO> cmDTO = null;
		List<CommentMaster> cm = titleRecord.getComments();
		if(cm == null){
			try {
				throw new EmptyRecords("There are no comments on title "+title+" to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		for (CommentMaster commentMaster : cm) {
			if(cmDTO == null)
				cmDTO = new ArrayList<CommentMasterDTO>();
			cmDTO.add(commentConversion.entity2dto(commentMaster));
		}	
		
		return cmDTO;
	}
	
	@Override
	public RatingMasterDTO addRating(RatingMasterDTO rating) {
		if(repository.findByTitle(rating.getTitle()) == null){
			try {
				throw new EmptyRecords("There are no records with title "+rating.getTitle()+" to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		RatingMaster rm = userRepository.addRating(ratingConversion.dto2entity(rating));
		return ratingConversion.entity2dto(rm);
	}
	
	@Override
	public List<imdbRecordDTO> viewTopRated() {
		List<RatingMaster> rm = userRepository.viewTopRated();
		if(rm == null){
			try {
				throw new EmptyRecords("There are no records to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		List<imdbRecordDTO> records = null;
		for (RatingMaster ratingMaster : rm) {
			if(records == null)
				records = new ArrayList<imdbRecordDTO>();
			records.add(conversion.entity2dto(ratingMaster.getRecord()));
		}
		return records;
	}
	
	@Override
	public int averageRating(String title) {
		imdbRecord record = repository.findByTitle(title);
		if(record == null){
			try {
				throw new EmptyRecords("There are no records to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		List<RatingMaster> ratings = record.getUserRatings();
		if(ratings == null){
			try {
				throw new EmptyRecords("There are no ratings for title "+title+" to show.");
			} catch (EmptyRecords e) {
				//e.printStackTrace();
			}
		}
		int totalStars = 0;
		int count = 0;
		for (RatingMaster rm : ratings) {
			totalStars = rm.getStar();
			count++;
		}
		return (totalStars/count);
	}
	
	@Override
	public User createUser(User user) {
		return userRepository.createUser(user);
	}
}
