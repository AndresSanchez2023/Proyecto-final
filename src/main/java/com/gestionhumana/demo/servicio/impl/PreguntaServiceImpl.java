package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.Pregunta;
import com.gestionhumana.demo.repositorio.PreguntaRepository;
import com.gestionhumana.demo.servicio.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta savePregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Optional<Pregunta> findById(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override
    public List<Pregunta> findAllPreguntas() {
        return preguntaRepository.findAll();
    }

    @Override
    public List<Pregunta> findBySurveyId(Long surveyId) {
        return preguntaRepository.findBySurveyId(surveyId);
    }

    @Override
    public void deletePregunta(Long id) {
        preguntaRepository.deleteById(id);
    }

}

