package com.prueba.veterinaria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.prueba.veterinaria.config.exception.NotFoundException;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.dto.PetDTO;
import com.prueba.veterinaria.model.Pet;
import com.prueba.veterinaria.service.IPetService;
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
@RequestMapping("/vet/pet")
public class PetController {
    
    @Autowired
    private IPetService servicePet;

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    public PetDTO save(@Valid @RequestBody PetDTO petDTO) {

        Pet pet = modelMapper.map(petDTO, Pet.class);
        pet = servicePet.savePet(pet);
        return modelMapper.map(pet,PetDTO.class);
    }

    @GetMapping("/{id}")
	public PetDTO findById(@PathVariable("id") int pet_id) {	

        Optional<Pet> pet = servicePet.searchById(pet_id);
        if(pet.isPresent()) {

            return modelMapper.map(pet.get(), PetDTO.class);
        }else{

            throw new NotFoundException("No se encontro ningun usuario");
        }
	}

    @GetMapping("/my/{id}")
	public List<PetDTO> findByAllPetsMemberID(@PathVariable("id") int member_id) {	

        List<Pet> petList = servicePet.searchAllPets(member_id);
		
        return petList.stream()
            .map(Pet -> modelMapper
            .map(Pet, PetDTO.class))
            .collect(Collectors.toList()); 
	}

    @GetMapping()
	public List<PetDTO> findAllPets() {		

        List<Pet> petList = servicePet.searchAll();
		
        return petList.stream()
            .map(Pet -> modelMapper
            .map(Pet, PetDTO.class))
            .collect(Collectors.toList());        
	}

    @DeleteMapping("/{id}")
	public Response deleteById(@PathVariable("id") int pet_id) {

		return servicePet.delete(pet_id);
	}
}
