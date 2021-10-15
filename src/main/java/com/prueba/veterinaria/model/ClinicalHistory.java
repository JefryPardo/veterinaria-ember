package com.prueba.veterinaria.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="clinical_history")
public class ClinicalHistory {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @NotNull(message = "Mascota: No valida.")
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;
    
    @NotNull(message = "Fecha: No valida.")
    private Date creationDate;
}
