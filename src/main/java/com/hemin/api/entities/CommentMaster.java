package com.hemin.api.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class CommentMaster {
	
	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	@Column(length = 5000)
	private String comment;
	
	@ManyToOne(cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private imdbRecord record;
	
	@ManyToOne(cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public imdbRecord getRecord() {
		return record;
	}
	
	public void setRecord(imdbRecord record) {
		this.record = record;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
