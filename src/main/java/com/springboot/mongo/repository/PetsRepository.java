package com.springboot.mongo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongo.model.Pets;

@Repository
public interface PetsRepository extends MongoRepository<Pets, ObjectId> {
	Pets findBy_id(ObjectId _id);
}
