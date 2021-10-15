package com.prueba.veterinaria.dto;

import com.prueba.veterinaria.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {    
    
    private int id;
    private String petName;
    private String breed;
    private Member member;
    private String gender;
}
