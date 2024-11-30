package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.RespuestaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaUsuarioRepository extends JpaRepository<RespuestaUsuario, Long> {

    List<RespuestaUsuario> findByUserSurveyId(Long userSurveyId);

    List<RespuestaUsuario> findByQuestionId(Long questionId);

    List<RespuestaUsuario> findByUserSurveyIdAndQuestionId(Long userSurveyId, Long questionId);
}

