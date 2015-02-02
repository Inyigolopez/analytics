package com.teralyx.analytics.persistence.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	private String city;

	private Float longitude;

	private Float latitude;

	private String telephone;

	protected Store() {
	}

	public Store(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitud() {
		return latitude;
	}

	public void setLatitud(Float latitude) {
		this.latitude = latitude;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


}
