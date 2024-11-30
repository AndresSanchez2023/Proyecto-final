package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {

    List<Encuesta> findByCreatedById(Long adminId);

    List<Encuesta> findByIsEnabled(Boolean isEnabled);
}

