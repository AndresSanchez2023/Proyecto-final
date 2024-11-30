package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.RespuestaUsuario;
import com.gestionhumana.demo.repositorio.RespuestaUsuarioRepository;
import com.gestionhumana.demo.servicio.RespuestaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaUsuarioServiceImpl implements RespuestaUsuarioService {

    @Autowired
    private RespuestaUsuarioRepository respuestaUsuarioRepository;

    @Override
    public RespuestaUsuario saveRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
        return respuestaUsuarioRepository.save(respuestaUsuario);
    }

    @Override
    public Optional<RespuestaUsuario> findById(Long id) {
        return respuestaUsuarioRepository.findById(id);
    }

    @Override
    public List<RespuestaUsuario> findAllRespuestas() {
        return respuestaUsuarioRepository.findAll();
    }

    @Override
    public List<RespuestaUsuario> findByUserSurveyId(Long userSurveyId) {
        return respuestaUsuarioRepository.findByUserSurveyId(userSurveyId);
    }

    @Override
    public List<RespuestaUsuario> findByQuestionId(Long questionId) {
        return respuestaUsuarioRepository.findByQuestionId(questionId);
    }

    @Override
    public List<RespuestaUsuario> findByUserSurveyIdAndQuestionId(Long userSurveyId, Long questionId) {
        return respuestaUsuarioRepository.findByUserSurveyIdAndQuestionId(userSurveyId, questionId);
    }

    @Override
    public void deleteRespuestaUsuario(Long id) {
        respuestaUsuarioRepository.deleteById(id);
    }
}

