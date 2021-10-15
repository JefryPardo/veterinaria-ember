package com.prueba.veterinaria.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.ClinicalHistory;

public interface IClinicalHistoryService {
    
    Optional<ClinicalHistory> searchById(int clinical_history_id);
    ClinicalHistory saveClinicalHistory(@Valid ClinicalHistory clinical_history);
    Response delete(int clinical_history_id);
    List<ClinicalHistory> searchAll();
}
