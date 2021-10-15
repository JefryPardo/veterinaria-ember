package com.prueba.veterinaria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.prueba.veterinaria.config.exception.NotFoundException;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.dto.CollaboratorDTO;
import com.prueba.veterinaria.model.Collaborator;
import com.prueba.veterinaria.service.ICollaboratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vet/collaborator")
public class CollaboratorController {
    
    @Autowired
    private ICollaboratorService serviceCollaborator;

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    public CollaboratorDTO save(@Valid @RequestBody CollaboratorDTO collaboratorDTO) {

        Collaborator collaborator = modelMapper.map(collaboratorDTO, Collaborator.class);
        collaborator = serviceCollaborator.saveCollaborator(collaborator);
        return modelMapper.map(collaborator,CollaboratorDTO.class);
    }

    @GetMapping
	public List<CollaboratorDTO> searchAllCollaborator() {

        List<Collaborator> collaborators = serviceCollaborator.searchAll();
        return collaborators.stream()
            .map(Collaborator -> modelMapper
            .map(Collaborator, CollaboratorDTO.class))
            .collect(Collectors.toList()); 
	}

    @GetMapping("/{id}")
	public CollaboratorDTO findById(@Valid @PathVariable("id") int collaborator_id) {

        Optional<Collaborator> collaborator = serviceCollaborator.searchById(collaborator_id);
        if(collaborator.isPresent()) {

            return modelMapper.map(collaborator.get(), CollaboratorDTO.class);
        }else{

            throw new NotFoundException("No se encontro ningun colaborador con el id: "+collaborator_id);
        } 
	}

    @GetMapping("/cc/{id}")
	public Response findByCC(@Valid @PathVariable("id") int identificationDocument) {

        Optional<Collaborator> collaborator = serviceCollaborator.searchByCC(identificationDocument);
        if(collaborator.isPresent()) {

            return new Response("No disponible.","La cedula no esta disponible: ","error");
        }else{

            return new Response("Disponible.","La cedula esta disponible: ","OK");
        } 
	}

    @DeleteMapping("/{id}")
	public Response deleteById(@PathVariable("id") int collaborator_id) {

		return serviceCollaborator.delete(collaborator_id);
	}
}