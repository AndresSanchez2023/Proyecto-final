package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.modelo.EncuestaUsuario;
import com.gestionhumana.demo.modelo.UsuarioNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaUsuarioRepository extends JpaRepository<EncuestaUsuario, Long> {
    EncuestaUsuario findByUserAndSurvey(UsuarioNormal user, Encuesta survey);
}
