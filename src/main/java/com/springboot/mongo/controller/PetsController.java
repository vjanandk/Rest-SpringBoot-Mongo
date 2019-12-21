package com.springboot.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongo.model.Pets;
import com.springboot.mongo.repository.PetsRepository;

@RestController
@RequestMapping("/api/pets")
public class PetsController {

	@Autowired
	private PetsRepository petsRepo;

	@GetMapping
	public List<Pets> getPets() {
		return petsRepo.findAll();

	}

	@GetMapping("/{id}")
	public Pets getPet(@PathVariable("id") ObjectId id) {
		return petsRepo.findBy_id(id);
	}

	@PutMapping("/{id}")
	public void updatePet(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pet) {
		pet.setId(id);
		petsRepo.save(pet);
	}

	@PostMapping
	public Pets addPet(@Valid @RequestBody Pets pet) {
		pet.setId(ObjectId.get());
		petsRepo.save(pet);
		return pet;
	}
	
	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable("id") ObjectId id) {
		petsRepo.delete(petsRepo.findBy_id(id));
	}

}
