package com.prueba.veterinaria.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.DetailClinicalHistory;

public interface IDetailClinicalHistoryService {
    
    List<DetailClinicalHistory> searchAll();
    Optional<DetailClinicalHistory> searchById(int detail_clinical_history_id);
    DetailClinicalHistory saveDetailClinicalHistory(@Valid DetailClinicalHistory detail_clinical_history);
    Response delete(int detail_clinical_history_id);
}
