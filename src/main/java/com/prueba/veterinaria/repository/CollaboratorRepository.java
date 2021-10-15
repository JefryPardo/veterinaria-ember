package com.prueba.veterinaria.repository;

import java.util.Optional;
import com.prueba.veterinaria.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator,Integer>{

    Optional<Collaborator> findByIdentificationDocument(int identificationDocument);
}
