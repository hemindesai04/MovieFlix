package com.hemin.api.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries(@NamedQuery(name = "imdbRecord.findByTitle", query = "SELECT r FROM imdbRecord r WHERE r.Title=:pTitle"))
public class imdbRecord {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;  //0
	
	@Column(nullable = false)
	private String Title;  //1
	
	private String Year;  //2
	
	private String Rated;  //3
	
	private Date Released;  //4
	
	private int Runtime;  //5

	@Column(length = 5000)
	private String Plot;  //6
	
	private String Awards;  //7
	
	private String Poster;  //8
	
	private int Metascore;  //9
	
	private double imdbRating;  //10
	
	private Number imdbVotes;  //11
	
	@Column(unique = true, nullable = false)
	private String imdbID;  //12
	
	@Column(nullable = false)
	private String Type; //13
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<GenreMaster> genre;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ActorMaster> actors;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CountryMaster> country;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<DirectorMaster> director;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<LanguageMaster> language;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<WriterMaster> writer;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "record")
	private List<CommentMaster> comments;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "record")
	private List<RatingMaster> userRatings;
	
	public List<RatingMaster> getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(List<RatingMaster> userRatings) {
		this.userRatings = userRatings;
	}
	public Set<ActorMaster> getActors() {
		return actors;
	}
	public void setActors(Set<ActorMaster> actors) {
		this.actors = actors;
	}
	public Set<CountryMaster> getCountry() {
		return country;
	}
	public void setCountry(Set<CountryMaster> country) {
		this.country = country;
	}
	public Set<DirectorMaster> getDirector() {
		return director;
	}
	public void setDirector(Set<DirectorMaster> director) {
		this.director = director;
	}
	public Set<LanguageMaster> getLanguage() {
		return language;
	}
	public void setLanguage(Set<LanguageMaster> language) {
		this.language = language;
	}
	public Set<WriterMaster> getWriter() {
		return writer;
	}
	public void setWriter(Set<WriterMaster> writer) {
		this.writer = writer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		this.Year = year;
	}
	public Date getReleased() {
		return Released;
	}
	public void setReleased(Date Released) {
		this.Released = Released;
	}
	public int getRuntime() {
		return Runtime;
	}
	public void setRuntime(int runtime) {
		this.Runtime = runtime;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		this.Plot = plot;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		this.Awards = awards;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		this.Poster = poster;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public Number getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(Number imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public int getMetascore() {
		return Metascore;
	}
	public void setMetascore(int metascore) {
		this.Metascore = metascore;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		this.Rated = rated;
	}
	
	public Set<GenreMaster> getGenre() {
		return genre;
	}
	public void setGenre(Set<GenreMaster> genre) {
		this.genre = genre;
	}
	
	public List<CommentMaster> getComments() {
		return comments;
	}
	public void setComments(List<CommentMaster> comments) {
		this.comments = comments;
	}
	
}
