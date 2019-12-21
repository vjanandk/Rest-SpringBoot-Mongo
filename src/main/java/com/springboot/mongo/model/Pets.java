package com.springboot.mongo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pets {
	
	@Id
	private ObjectId _id;
	
	private String name;
	private String species;
	private String breed;
	
	public Pets() {}
	
	public Pets(ObjectId _id, String name, String species, String breed) {
		this._id = _id;
		this.name = name;
		this.species = species;
		this.breed = breed;
	}
	
	public ObjectId getId() {
		return this._id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	public void setId(ObjectId id) {
		this._id = id;
	}
}
