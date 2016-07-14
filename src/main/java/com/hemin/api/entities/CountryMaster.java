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
		@NamedQuery(name = "CountryMaster.findByCountryName", query = "SELECT c FROM CountryMaster c WHERE countryName=:pcountryName"))
public class CountryMaster {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	@Column(nullable = false)
	private String countryName;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "country")
	private	Set<imdbRecord> records;
	
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
