package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.Usuario;

import java.util.Optional;

public interface UsuarioService {
    public Optional<Usuario> findByUsername(String username);

    public Usuario saveUsuario(Usuario usuario);

    public Optional<Usuario> findByNumeroDocumento(Long numeroDocumento);
}
