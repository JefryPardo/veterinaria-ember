package com.prueba.veterinaria.dto;

import java.util.Date;
import com.prueba.veterinaria.model.ClinicalHistory;
import com.prueba.veterinaria.model.Collaborator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailClinicalHistoryDTO {

    private int id;
    private String temperature;
    private int weight;
    private int cardiacFrequency;
    private int breathingRate;
    private Date dateTime;
    private String feeding;
    private String habitat;
    private String comments;
    private Collaborator collaborator;
    private ClinicalHistory clinicalHistory;
}
