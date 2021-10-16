package com.prueba.veterinaria.repository;

import java.util.List;

import com.prueba.veterinaria.model.DetailClinicalHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailClinicalHistoryRepository extends JpaRepository<DetailClinicalHistory,Integer>{

    List<DetailClinicalHistory> findByClinicalHistoryId(int clinicalHistori_id);
}
