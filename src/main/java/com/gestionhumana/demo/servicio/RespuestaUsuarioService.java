package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.RespuestaUsuario;

import java.util.List;
import java.util.Optional;

public interface RespuestaUsuarioService {

    RespuestaUsuario saveRespuestaUsuario(RespuestaUsuario respuestaUsuario);

    Optional<RespuestaUsuario> findById(Long id);

    List<RespuestaUsuario> findAllRespuestas();

    List<RespuestaUsuario> findByUserSurveyId(Long userSurveyId);

    List<RespuestaUsuario> findByQuestionId(Long questionId);

    List<RespuestaUsuario> findByUserSurveyIdAndQuestionId(Long userSurveyId, Long questionId);

    void deleteRespuestaUsuario(Long id);
}

