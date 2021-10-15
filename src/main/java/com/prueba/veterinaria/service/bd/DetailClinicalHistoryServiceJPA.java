package com.prueba.veterinaria.service.bd;

import java.util.List;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.DetailClinicalHistory;
import com.prueba.veterinaria.repository.DetailClinicalHistoryRepository;
import com.prueba.veterinaria.service.IDetailClinicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class DetailClinicalHistoryServiceJPA implements IDetailClinicalHistoryService{

    @Autowired
    private DetailClinicalHistoryRepository detailClinicalHistoryRepo;

    public List<DetailClinicalHistory> searchAll() {
        
        return detailClinicalHistoryRepo.findAll();
    }

    public Optional<DetailClinicalHistory> searchById(int detail_clinical_history_id) {
        
        return detailClinicalHistoryRepo.findById(detail_clinical_history_id);
    }

    public DetailClinicalHistory saveDetailClinicalHistory(DetailClinicalHistory detail_clinical_history) {
        
        return detailClinicalHistoryRepo.save(detail_clinical_history);
    }

    
    public Response delete(int detail_clinical_history_id) {
        
        try {

            detailClinicalHistoryRepo.deleteById(detail_clinical_history_id);
            return new Response("Con exito.","Se pudo borrar los detalles de la historia clinica con id: "+detail_clinical_history_id,"200 OK");
        } catch (Exception e) {
            
            return new Response("Sin exito","No se pudo borrar los detalles de la historia clinica con id: "+detail_clinical_history_id,"404 Not Found");                
        }
    }
    
}
