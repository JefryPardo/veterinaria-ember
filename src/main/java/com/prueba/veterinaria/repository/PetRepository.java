package com.prueba.veterinaria.repository;

import com.prueba.veterinaria.model.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Integer>{}
