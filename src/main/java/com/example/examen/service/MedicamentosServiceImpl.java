package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Medicamentos;
import com.example.examen.repository.MedicamentoRepository;

@Service
public class MedicamentosServiceImpl implements MedicamentosService{
    



    // SERVICE IMPL CRUD 

    @Autowired
    private MedicamentoRepository repository;



    @Override
    public List<Medicamentos> findAll() {

        return repository.findAll();
    }



    @Override
    public Optional<Medicamentos> getMedicamentForId(int medicamento_id) {

        return repository.findById(medicamento_id);
    }



    @Override
    public Medicamentos saveMedicaments(Medicamentos medicamentos) {

        return repository.save(medicamentos);
    }




    @Override
    public void deleteMedicamentos(int medicamento_id) {
         repository.deleteById(medicamento_id);
    }








}
