package com.hemin.api.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class imdbRecordDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;  //0
	
	private String Title;  //1
	
	private String Year;  //2
	
	private String Rated;  //3
	
	private String Released;  //4
	
	private String Runtime;  //5
	
	private String Genre;
	
	private String Director;
	
	private String Writer;
	
	private String Actors;

	private String Plot;  //6
	
	private String Language;
	
	private String Country;
	
	private String Awards;  //7
	
	private String Poster;  //8
	
	private String Metascore;  //9
	
	private String imdbRating;  //10
	
	private String imdbVotes;  //11
	
	private String imdbID;  //12
	
	private String Type; //13

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}
	
	@JsonProperty("Title")
	public void setTitle(String title) {
		this.Title = title;
	}

	public String getYear() {
		return Year;
	}

	@JsonProperty("Year")
	public void setYear(String year) {
		this.Year = year;
	}

	public String getRated() {
		return Rated;
	}

	@JsonProperty("Rated")
	public void setRated(String rated) {
		this.Rated = rated;
	}

	public String getReleased() {
		return Released;
	}

	@JsonProperty("Released")
	public void setReleased(String releasedDate) {
		this.Released = releasedDate;
	}

	public String getRuntime() {
		return Runtime;
	}

	@JsonProperty("Runtime")
	public void setRuntime(String runtime) {
		this.Runtime = runtime;
	}

	public String getPlot() {
		return Plot;
	}

	@JsonProperty("Plot")
	public void setPlot(String plot) {
		this.Plot = plot;
	}

	public String getAwards() {
		return Awards;
	}

	@JsonProperty("Awards")
	public void setAwards(String awards) {
		this.Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	@JsonProperty("Poster")
	public void setPoster(String poster) {
		this.Poster = poster;
	}

	public String getMetascore() {
		return Metascore;
	}

	@JsonProperty("Metascore")
	public void setMetascore(String metascore) {
		this.Metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
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

	@JsonProperty("Type")
	public void setType(String type) {
		this.Type = type;
	}

	public String getGenre() {
		return Genre;
	}

	@JsonProperty("Genre")
	public void setGenre(String genre) {
		this.Genre = genre;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return Director;
	}

	/**
	 * @param director the director to set
	 */
	@JsonProperty("Director")
	public void setDirector(String director) {
		this.Director = director;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return Writer;
	}

	/**
	 * @param writer the writer to set
	 */
	@JsonProperty("Writer")
	public void setWriter(String writer) {
		this.Writer = writer;
	}

	/**
	 * @return the actors
	 */
	public String getActors() {
		return Actors;
	}

	/**
	 * @param actors the actors to set
	 */
	@JsonProperty("Actors")
	public void setActors(String actors) {
		this.Actors = actors;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return Language;
	}

	/**
	 * @param language the language to set
	 */
	@JsonProperty("Language")
	public void setLanguage(String language) {
		this.Language = language;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * @param country the country to set
	 */
	@JsonProperty("Country")
	public void setCountry(String country) {
		this.Country = country;
	}
}
