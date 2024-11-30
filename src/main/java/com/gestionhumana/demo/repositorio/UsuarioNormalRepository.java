package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.UsuarioNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioNormalRepository extends JpaRepository<UsuarioNormal, Long> {


    Optional<UsuarioNormal> findByNumeroDocumento(Long numeroDocumento);
}
