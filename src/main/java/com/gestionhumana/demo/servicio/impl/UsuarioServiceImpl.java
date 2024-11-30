package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.Usuario;
import com.gestionhumana.demo.repositorio.UsuarioRepository;
import com.gestionhumana.demo.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl  implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByNumeroDocumento(Long numeroDocumento) {
        return usuarioRepository.findByNumeroDocumento(numeroDocumento);
    }
}
