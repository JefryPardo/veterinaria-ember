package com.prueba.veterinaria.dto;

import java.util.Date;
import com.prueba.veterinaria.model.Pet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicalHistoryDTO {
    
    private int id;
    private Pet pet;
    private Date creationDate;
}
