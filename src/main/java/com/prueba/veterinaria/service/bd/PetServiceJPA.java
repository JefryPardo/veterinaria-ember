package com.prueba.veterinaria.service.bd;

import java.util.List;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Pet;
import com.prueba.veterinaria.repository.PetRepository;
import com.prueba.veterinaria.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PetServiceJPA implements IPetService{

    @Autowired
    private PetRepository petRepo;

    public List<Pet> searchAll() {
        
        return petRepo.findAll();
    }

    public Optional<Pet> searchById(int pet_id) {
        
        return petRepo.findById(pet_id);
    }

    public Pet savePet(Pet pet) {
        
        return petRepo.save(pet);
    }

    
    public Response delete(int pet_id) {
        
        try {
            petRepo.deleteById(pet_id);
             return new Response("Con exito.","Se pudo borrar la mascota con id: "+pet_id,"200 OK");
        } catch (Exception e) {
            return new Response("Sin exito","No se pudo borrar la mascota con id: "+pet_id,"404 Not Found");                
        }
    }

    @Override
    public List<Pet> searchAllPets(int member_id) {
        
        return petRepo.findByMember(member_id);
    }
    
}
