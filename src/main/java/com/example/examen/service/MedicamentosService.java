package com.example.examen.service;
import java.util.List;
import java.util.Optional;

import com.example.examen.entity.Medicamentos;

public interface MedicamentosService {
    

    // SERVICE INTERFACE 


     //   CRUD

    public abstract List<Medicamentos> findAll();

    public abstract Optional<Medicamentos> getMedicamentForId(int medicamento_id);


    public abstract Medicamentos saveMedicaments(Medicamentos medicamentos);


    public abstract void deleteMedicamentos(int medicamento_id);


}
