package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {

    Encuesta saveEncuesta(Encuesta encuesta);

    Optional<Encuesta> findById(Long id);

    List<Encuesta> findAllEncuestas();

    List<Encuesta> findByAdminId(Long adminId);

    List<Encuesta> findByIsEnabled(Boolean isEnabled);

    void deleteEncuesta(Long id);
}

