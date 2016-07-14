package com.hemin.api.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


//class for mapped to language master table using Spring ORM
@Entity
@Table
@NamedQueries(
		@NamedQuery(name ="LanguageMaster.findByLanguageName", query ="SELECT l FROM LanguageMaster l WHERE lang=:plang"))
public class LanguageMaster {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	@Column(nullable = false)
	private String lang;
	
	@ManyToMany(cascade = {
			CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, mappedBy = "country")
	private Set<imdbRecord> records;
	
	public Set<imdbRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<imdbRecord> records) {
		this.records = records;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
