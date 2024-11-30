package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta savePregunta(Pregunta pregunta);

    Optional<Pregunta> findById(Long id);

    List<Pregunta> findAllPreguntas();

    List<Pregunta> findBySurveyId(Long surveyId);

    void deletePregunta(Long id);
}

