package com.hospitalVM.atencion.repository;

import com.hospitalVM.atencion.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Optional<Medico> findByRun(String run);
}
