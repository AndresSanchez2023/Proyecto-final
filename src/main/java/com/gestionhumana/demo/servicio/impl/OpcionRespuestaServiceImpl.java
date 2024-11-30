package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.OpcionRespuesta;
import com.gestionhumana.demo.repositorio.OpcionRespuestaRepository;
import com.gestionhumana.demo.servicio.OpcionRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionRespuestaServiceImpl implements OpcionRespuestaService {

    @Autowired
    private OpcionRespuestaRepository opcionRespuestaRepository;

    @Override
    public OpcionRespuesta saveOpcionRespuesta(OpcionRespuesta opcionRespuesta) {
        return opcionRespuestaRepository.save(opcionRespuesta);
    }

    @Override
    public Optional<OpcionRespuesta> findById(Long id) {
        return opcionRespuestaRepository.findById(id);
    }

    @Override
    public List<OpcionRespuesta> findAllOpcionesRespuesta() {
        return opcionRespuestaRepository.findAll();
    }

    @Override
    public List<OpcionRespuesta> findByQuestionId(Long questionId) {
        return opcionRespuestaRepository.findByQuestionId(questionId);
    }

    @Override
    public void deleteOpcionRespuesta(Long id) {
        opcionRespuestaRepository.deleteById(id);
    }
}

