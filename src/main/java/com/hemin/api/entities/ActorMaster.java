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

@Entity
@Table
@NamedQueries(@NamedQuery(name = "ActorMaster.findByActorName", query = "SELECT a FROM ActorMaster a WHERE actorName=:pactorName"))
public class ActorMaster {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	@Column(nullable = false, unique = true)
	private String actorName;
	
	@ManyToMany(cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "actors")
	private Set<imdbRecord> records;
	
	/**
	 * @return the records
	 */
	public Set<imdbRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(Set<imdbRecord> records) {
		this.records = records;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
}
