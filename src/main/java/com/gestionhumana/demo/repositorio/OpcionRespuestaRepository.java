package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.OpcionRespuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcionRespuestaRepository extends JpaRepository<OpcionRespuesta, Long> {

    List<OpcionRespuesta> findByQuestionId(Long questionId);
}
