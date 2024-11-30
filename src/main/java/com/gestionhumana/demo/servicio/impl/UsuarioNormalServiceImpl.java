package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.excepcion.DependenciaNotFoundException;
import com.gestionhumana.demo.excepcion.UsuarioNormalFoundException;
import com.gestionhumana.demo.modelo.Dependencia;
import com.gestionhumana.demo.modelo.UsuarioNormal;
import com.gestionhumana.demo.repositorio.DependenciaRepository;
import com.gestionhumana.demo.repositorio.UsuarioNormalRepository;
import com.gestionhumana.demo.servicio.UsuarioNormalService;
import com.gestionhumana.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioNormalServiceImpl implements UsuarioNormalService {

    @Autowired
    private UsuarioNormalRepository usuarioNormalRepository;

    @Autowired
    private DependenciaRepository dependenciaRepository;

    public UsuarioNormal saveUsuarioNormal(UsuarioNormal usuarioNormal) {
        Optional<UsuarioNormal> usuarioNormalLocal = usuarioNormalRepository.findByNumeroDocumento(usuarioNormal.getNumeroDocumento());
        if (usuarioNormalLocal.isPresent()) {
            throw new UsuarioNormalFoundException(Constants.USUARIO_ENCONTRADO_POR_DOCUMENTO);
        }
        Long dependenciaId = usuarioNormal.getDependencia().getId();
        Dependencia dependencia = dependenciaRepository.findById(dependenciaId)
                .orElseThrow(() -> new DependenciaNotFoundException("Dependencia no encontrada"));

        usuarioNormal.setDependencia(dependencia);
        return usuarioNormalRepository.save(usuarioNormal);
    }

    public Optional<UsuarioNormal> findByNumeroDocumento(Long numeroDocumento) {
        return usuarioNormalRepository.findByNumeroDocumento(numeroDocumento);
    }
}
