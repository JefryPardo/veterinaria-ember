package com.prueba.veterinaria.repository;

import java.util.List;

import com.prueba.veterinaria.model.ClinicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory,Integer>{

    List<ClinicalHistory> findByPetId(int pet_id);
}
