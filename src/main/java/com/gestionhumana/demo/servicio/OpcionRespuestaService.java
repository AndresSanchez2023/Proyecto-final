package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.OpcionRespuesta;

import java.util.List;
import java.util.Optional;

public interface OpcionRespuestaService {

    OpcionRespuesta saveOpcionRespuesta(OpcionRespuesta opcionRespuesta);

    Optional<OpcionRespuesta> findById(Long id);

    List<OpcionRespuesta> findAllOpcionesRespuesta();

    List<OpcionRespuesta> findByQuestionId(Long questionId);

    void deleteOpcionRespuesta(Long id);
}
