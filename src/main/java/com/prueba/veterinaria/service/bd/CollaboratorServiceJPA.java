package com.prueba.veterinaria.service.bd;

import java.util.List;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Collaborator;
import com.prueba.veterinaria.repository.CollaboratorRepository;
import com.prueba.veterinaria.service.ICollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CollaboratorServiceJPA implements ICollaboratorService{

    @Autowired
    private CollaboratorRepository collaboratorRepo;

    public List<Collaborator> searchAll() {
        
        return collaboratorRepo.findAll();
    }

    public Collaborator saveCollaborator(Collaborator collaborator) {
        
        return collaboratorRepo.save(collaborator);
    }

    @Override
    public Optional<Collaborator> searchById(int collaborator_id) {
        
        return collaboratorRepo.findById(collaborator_id);
    }

    @Override
    public Response delete(int collaborator_id) {
        
        try {
            collaboratorRepo.deleteById(collaborator_id);
             return new Response("Con exito.","Se pudo borrar el colaborador con id: "+collaborator_id,"200 OK");
        } catch (Exception e) {
            return new Response("Sin exito","No se pudo borrar el colaborador con id: "+collaborator_id,"404 Not Found");                
        }
    }

    @Override
    public Optional<Collaborator> searchByCC(int identificationDocument) {
        
        return collaboratorRepo.findByIdentificationDocument(identificationDocument);
    }    
}
