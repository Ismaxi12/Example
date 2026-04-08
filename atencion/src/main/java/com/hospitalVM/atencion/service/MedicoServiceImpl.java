package com.hospitalVM.atencion.service;

import com.hospitalVM.atencion.exception.MedicoExistenteException;
import com.hospitalVM.atencion.exception.MedicoInexistenteException;
import com.hospitalVM.atencion.model.Medico;
import com.hospitalVM.atencion.repository.MedicoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional(readOnly=true)
    @Override
    public List<Medico> findAll(){
        return this.medicoRepository.findAll();

    }
    @Transactional(readOnly=true)
    @Override
    public Medico findById(long id) {
        return this.medicoRepository.findById(id).orElseThrow(
                ()-> new MedicoInexistenteException("Medico con id:"+id+" no encontrado")

        );
    }
    @Transactional(readOnly=true)
    @Override
    public Medico findByRun(String run) {
        return this.medicoRepository.findByRun(run).orElseThrow(
                ()-> new MedicoInexistenteException("Medico con rut:"+run+" no encontrado")
        );
    }
    @Transactional
    @Override
    public Medico save(Medico medico) {
        if (this.medicoRepository.findByRun(medico.getRun()).isPresent()) {
            throw new MedicoExistenteException("Medico con rut:"+medico.getRun()+" ya existe");
        }
        return this.medicoRepository.save(medico);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        this.medicoRepository.deleteById(id);
    }

    @Override
    public Medico updateById(Long id, Medico medico) {
        return this.medicoRepository.findById(id).map(element ->{
            //element.setRun(medico.getRun());
            element.setJefeTurno(medico.getJefeTurno());
            element.setNombreCompleto(medico.getNombreCompleto());
            return this.medicoRepository.save(element);


        }).orElseThrow(
                ()-> new MedicoInexistenteException("El medico con id: "+id+"no existe")
        );
    }
}
