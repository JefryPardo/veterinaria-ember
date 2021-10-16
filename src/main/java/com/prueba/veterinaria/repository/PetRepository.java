package com.prueba.veterinaria.repository;

import java.util.List;

import com.prueba.veterinaria.model.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Integer>{

    List<Pet> findByMember(int identificationDocument);
}
