package com.prueba.veterinaria.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Pet;

public interface IPetService {
    
    List<Pet> searchAll();
    Optional<Pet> searchById(int pet_id);
    Pet savePet(@Valid Pet pet);
    Response delete(int pet_id);
}
