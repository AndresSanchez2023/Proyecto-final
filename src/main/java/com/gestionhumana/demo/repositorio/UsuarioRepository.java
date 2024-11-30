package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);


    Optional<Usuario> findByNumeroDocumento(Long numeroDocumento);
}
