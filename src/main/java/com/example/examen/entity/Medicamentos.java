package com.example.examen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicamentos")
public class Medicamentos {

    // CLASE GUIA Medicamento 

        // parametros iguales 

    @Id
    @Column(name = "medicamento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicamento_id;

    private String nombre;

    private String descripcion;

    private int costo;




}
