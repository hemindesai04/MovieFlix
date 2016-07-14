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
@NamedQueries(
		@NamedQuery(name = "WriterMaster.findByWriterName", query = "SELECT w FROM WriterMaster w WHERE writerName=:pwriterName"))
public class WriterMaster {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	@Column(nullable = false)
	private String writerName;

	@ManyToMany(cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH	}, mappedBy = "writer")
	private Set<imdbRecord> records;
	
	public String getId() {
		return id;
	}

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

	public void setId(String id) {
		this.id = id;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
}
