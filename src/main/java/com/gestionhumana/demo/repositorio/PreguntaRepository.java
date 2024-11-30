package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    List<Pregunta> findBySurveyId(Long surveyId);

    @Override
    boolean existsById(Long aLong);
}

