package com.prueba.veterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table( name = "member" )
public class Member {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @NotBlank(message = "Nombre: No valido.")
    @NotNull(message = "Nombre: No valido.")
    @Column(name = "member_name")
    private String memberName;

    @NotBlank(message = "Apellido: No valido.")
    @NotNull(message = "Apellido: No valido.")
    @Column(name = "member_last_name")
    private String memberLastName;

    @NotBlank(message = "Tipo de documento: No valido.")
    @NotNull(message = "Tipo de documento: No valido.")
    @Column(name = "document_category")
    private String documentCantegory;

    @NotNull(message = "Documento: No valido.")
    @Column(name = "identification_document")
    private int identificationDocument;

    @NotBlank(message = "Estado: No valido.")
    @NotNull(message = "Estado: No valido.")
    @Column(name = "member_state")
    private String memberState;

    @NotNull(message = "Genero: No validad.")
    private int gender;
}
