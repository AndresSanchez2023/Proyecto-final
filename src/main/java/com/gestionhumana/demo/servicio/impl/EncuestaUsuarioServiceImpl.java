package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.modelo.EncuestaUsuario;
import com.gestionhumana.demo.modelo.UsuarioNormal;
import com.gestionhumana.demo.repositorio.EncuestaUsuarioRepository;
import com.gestionhumana.demo.servicio.EncuestaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaUsuarioServiceImpl implements EncuestaUsuarioService {

    @Autowired
    private EncuestaUsuarioRepository encuestaUsuarioRepository;

    @Override
    public EncuestaUsuario saveEncuestaUsuario(EncuestaUsuario encuestaUsuario) {
        return encuestaUsuarioRepository.save(encuestaUsuario);
    }

    @Override
    public Optional<EncuestaUsuario> findById(Long id) {
        return encuestaUsuarioRepository.findById(id);
    }

    @Override
    public List<EncuestaUsuario> findAll() {
        return encuestaUsuarioRepository.findAll();
    }

    @Override
    public EncuestaUsuario findByUserAndSurvey(UsuarioNormal user, Encuesta survey) {
        return encuestaUsuarioRepository.findByUserAndSurvey(user, survey);
    }

    @Override
    public void deleteEncuestaUsuario(Long id) {
        encuestaUsuarioRepository.deleteById(id);
    }
}
