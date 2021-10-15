package com.prueba.veterinaria.model;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pet")
public class Pet {
    
    @Id
    @GeneratedValue( strategy =GenerationType.IDENTITY )
    private int id;

    @NotBlank(message = "Nombre mascota: No valido.")
    @NotNull(message="Nombre mascota: No valido.")
    @Column(name="pet_name")
    private String petName;

    @NotBlank(message = "Raza: No valida.")
    @NotNull(message = "Raza: No valida.")
    private String breed;

    @NotNull(message="Raza: No valida.")
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @NotBlank(message = "Genero: No valido.")
    @NotNull(message = "Genero: No valido.")
    private String gender;
}