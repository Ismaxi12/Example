package com.hospitalVM.atencion.service;

import com.hospitalVM.atencion.model.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> findAll();
    Medico findById(long id);
    Medico findByRun(String run);
    Medico save(Medico medico);
    void deleteById(Long id);
    Medico updateById(Long id,Medico medico);
}
