package com.prueba.veterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="collaborator")
public class Collaborator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Nombre Colaborador: No valido.")
    @NotBlank(message = "Nombre Colaborador: No valido.")
    @Column(name = "collaborator_name")
    private String collaboratorName;

    @NotNull(message = "Apellido Colaborador: No valido.")
    @NotBlank(message = "Apellido Colaborador: No valido.")
    @Column(name = "collaborator_last_name")
    private String collaboratorLastName;

    @NotNull(message = "Cargo Colaborador: No valido.")
    @NotBlank(message = "Cargo Colaborador: No valido.")
    @Column(name = "collaborator_position")
    private String collaboratorPosition;

    @NotNull(message = "Especialidad:  No valida.")
    @NotBlank(message = "Especialidad: No valida.")
    @Column(name = "speciality_area")
    private String specialityArea;

    @NotBlank(message = "tipo documento: No valido.")
    @NotNull(message = "tipo documento: No valido.")
    @Column(name = "document_category")
    private String documentCategory;

    @NotNull(message = "# de identificación: No valido.")
    @Column(name = "identification_document")
    private int identificationDocument;
}
