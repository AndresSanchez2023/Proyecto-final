package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.UsuarioNormal;

import java.util.Optional;

public interface UsuarioNormalService {

    UsuarioNormal saveUsuarioNormal(UsuarioNormal usuarioNormal);

    Optional<UsuarioNormal> findByNumeroDocumento(Long numeroDocumento);
}
