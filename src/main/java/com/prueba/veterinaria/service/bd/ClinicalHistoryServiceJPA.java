package com.prueba.veterinaria.service.bd;

import java.util.List;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.ClinicalHistory;
import com.prueba.veterinaria.repository.ClinicalHistoryRepository;
import com.prueba.veterinaria.service.IClinicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ClinicalHistoryServiceJPA implements IClinicalHistoryService{
    
    @Autowired
    private ClinicalHistoryRepository clinicalHistoryRepo;

    public Optional<ClinicalHistory> searchById(int clinical_history_id) {
        
        return clinicalHistoryRepo.findById(clinical_history_id);
    }

    public ClinicalHistory saveClinicalHistory(ClinicalHistory clinical_history) {
        
        return clinicalHistoryRepo.save(clinical_history);
    }
    
    public Response delete(int clinical_history_id) {

        try {

            clinicalHistoryRepo.deleteById(clinical_history_id);
            return new Response("Con exito.","Se pudo borrar la historia clinica con id: "+clinical_history_id,"200 OK");
        } catch (Exception e) {

            return new Response("Sin exito","No se pudo borrar la historia clinica con id: "+clinical_history_id,"404 Not Found");                
        }
    }

    public List<ClinicalHistory> searchAll() {
        
        return clinicalHistoryRepo.findAll();
    }

    @Override
    public Optional<ClinicalHistory> searchClinicalHistoryByPetId(int pet_id) {
        
        return clinicalHistoryRepo.findByPetId(pet_id);
    }    
}
