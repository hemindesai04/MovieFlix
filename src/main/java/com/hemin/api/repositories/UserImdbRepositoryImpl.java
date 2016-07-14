package com.hemin.api.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hemin.api.entities.CommentMaster;
import com.hemin.api.entities.RatingMaster;
import com.hemin.api.entities.User;
import com.hemin.api.entities.imdbRecord;

@Repository
public class UserImdbRepositoryImpl implements UserImdbRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<imdbRecord> findAllMovies() {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r WHERE Type='movie' ORDER BY r.Title ASC", imdbRecord.class);
		return query.getResultList();
		
	}

	@Override
	public List<imdbRecord> findAllTvSeries() {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r WHERE Type='series' ORDER BY r.Title ASC", imdbRecord.class);
		return query.getResultList();
	}

	@Override
	public List<imdbRecord> sortByImdbRatings() {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r ORDER BY r.imdbRating DESC", imdbRecord.class);
		return query.getResultList();
	}

	@Override
	public List<imdbRecord> sortByImdbVotes() {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r ORDER BY r.imdbVotes DESC", imdbRecord.class);
		return query.getResultList();
	}

	@Override
	public List<imdbRecord> sortByYear() {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r ORDER BY r.Year DESC", imdbRecord.class);
		return query.getResultList();
	}

	@Override
	public List<imdbRecord> filterByYear(String year) {
		TypedQuery<imdbRecord> query = em.createQuery("SELECT r FROM imdbRecord r WHERE r.Year=:pYear", imdbRecord.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	// method which adds comment on a specific title
	@Override
	public CommentMaster addComment(CommentMaster cm) {
		em.persist(cm);
		return cm;
	}

	@Override
	public RatingMaster addRating(RatingMaster rm) {
		em.persist(rm);
		return rm;
	}
	
	@Override
	public List<RatingMaster> viewTopRated() {
		TypedQuery<RatingMaster> query = em.createQuery("SELECT r FROM RatingMaster r ORDER BY r.star DESC", RatingMaster.class);
		return query.getResultList();
	}
	
	// CRUD for user
	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}
	
	@Override
	public User findUserByID(String user_id) {
		TypedQuery<User> query = em.createNamedQuery("User.findUserByID", User.class);
		query.setParameter("pId", user_id);
		List<User> userList = query.getResultList();
		if(userList != null && userList.size() == 1)
			return userList.get(0);
		else
			return null;	
	}

}
