package com.prueba.veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollaboratorDTO {

    private int id;
    private String collaboratorName;
    private String collaboratorLastName;
    private String collaboratorPosition;
    private String specialityArea;
    private String documentCategory;
    private int identificationDocument;
    private int state;
}
