package com.prueba.veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    
    private int id;
    private String memberName;
    private String memberLastName;
    private String documentCantegory;
    private int identificationDocument;
    private String memberState;
    private int gender;
}
