package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	String locality;
	String city;
	
	public Address(String locality, String city) {
		super();
		this.locality = locality;
		this.city = city;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", locality=" + locality + ", city=" + city + "]";
	}
	
	
	
	
}
