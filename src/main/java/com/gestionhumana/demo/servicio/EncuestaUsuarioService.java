package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.modelo.EncuestaUsuario;
import com.gestionhumana.demo.modelo.UsuarioNormal;

import java.util.List;
import java.util.Optional;

public interface EncuestaUsuarioService {

    EncuestaUsuario saveEncuestaUsuario(EncuestaUsuario encuestaUsuario);

    Optional<EncuestaUsuario> findById(Long id);

    List<EncuestaUsuario> findAll();

    EncuestaUsuario findByUserAndSurvey(UsuarioNormal user, Encuesta survey);

    void deleteEncuestaUsuario(Long id);
}
