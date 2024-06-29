package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Medicamentos;

public interface MedicamentoRepository extends JpaRepository<Medicamentos, Integer> {
    

    // CLASE REPOSITORY 
        // <Medicamentos, Integer> : clase guia y su id es int x eso se pone eso 
}
