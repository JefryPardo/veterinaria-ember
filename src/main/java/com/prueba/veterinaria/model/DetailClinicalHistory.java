package com.prueba.veterinaria.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="detail_clinical_history")
public class DetailClinicalHistory {
    
    @Id
    @GeneratedValue( strategy =GenerationType.IDENTITY )
    private int id;

    @NotBlank(message = "Temperatura: no validad.")
    @NotNull(message = "Temperatura: no validad.")
    private String temperature;

    @NotNull(message = "Peso: no validad.")
    private int weight;

    @NotNull(message = "Frecuencia cardiaca: no validad.")
    @Column(name="cardiac_frequency")
    private int cardiacFrequency;

    @NotNull(message = "Frecuencia respiratoria: no validad.")
    @Column(name="breathing_rate")
    private int breathingRate;

    @NotNull(message = "Fecha y hora respiratoria: no validad.")
    @Column(name="date_time")
    private Date dateTime;

    @NotBlank(message = "Alimentación: no validad.")
    @NotNull(message = "Alimentación: no validad.")
    private String feeding;

    @NotBlank(message = "Habitad: no validad.")
    @NotNull(message = "Habitad: no validad.")
    private String habitat;

    @NotBlank(message = "Observacione: no validad.")
    @NotNull(message = "Observacione: no validad.")
    private String comments;

    @NotNull(message = "Colaborador asignado: no valido.")
    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator;

    @NotNull(message = "Historia clinica asignada: no validad.")
    @ManyToOne
    @JoinColumn(name="clinical_history_id")
    private ClinicalHistory clinicalHistory;
}
