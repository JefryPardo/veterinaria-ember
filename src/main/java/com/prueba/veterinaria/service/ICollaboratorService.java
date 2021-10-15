package com.prueba.veterinaria.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Collaborator;

public interface ICollaboratorService {
    
    List<Collaborator> searchAll();
    Optional<Collaborator> searchById(int collaborator_id);
    Optional<Collaborator> searchByCC(int identificationDocument);
    Collaborator saveCollaborator(@Valid Collaborator collaborator);
    Response delete(int collaborator_id);
}
