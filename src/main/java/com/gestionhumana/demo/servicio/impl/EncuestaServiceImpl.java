package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.repositorio.EncuestaRepository;
import com.gestionhumana.demo.servicio.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaServiceImpl implements EncuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Override
    public Encuesta saveEncuesta(Encuesta encuesta) {
        return encuestaRepository.save(encuesta);
    }

    @Override
    public Optional<Encuesta> findById(Long id) {
        return encuestaRepository.findById(id);
    }

    @Override
    public List<Encuesta> findAllEncuestas() {
        return encuestaRepository.findAll();
    }

    @Override
    public List<Encuesta> findByAdminId(Long adminId) {
        return encuestaRepository.findByCreatedById(adminId);
    }

    @Override
    public List<Encuesta> findByIsEnabled(Boolean isEnabled) {
        return encuestaRepository.findByIsEnabled(isEnabled);
    }

    @Override
    public void deleteEncuesta(Long id) {
        encuestaRepository.deleteById(id);
    }
}

