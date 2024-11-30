package com.gestionhumana.demo.servicio.impl;

import com.gestionhumana.demo.excepcion.DependenciaFoundException;
import com.gestionhumana.demo.modelo.Dependencia;
import com.gestionhumana.demo.repositorio.DependenciaRepository;
import com.gestionhumana.demo.servicio.DependenciaService;
import com.gestionhumana.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenciaServiceImpl implements DependenciaService {
    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Override
    public Dependencia saveDependencia(Dependencia dependencia) {
        Dependencia dependenciaLocal = dependenciaRepository.findByName(dependencia.getName());
        if (dependenciaLocal != null){
            throw new DependenciaFoundException(Constants.DEPENDENCIA_ENCONTRADA_POR_NOMBRE);
        }
        return dependenciaRepository.save(dependencia);
    }

    @Override
    public Optional<Dependencia> findById(Long id) {
        return dependenciaRepository.findById(id);
    }

    @Override
    public List<Dependencia> findAllDependencias() {
        return dependenciaRepository.findAll();
    }

    @Override
    public Dependencia findByName(String name) {
        return dependenciaRepository.findByName(name);
    }

    @Override
    public void deleteDependencia(Long id) {
        dependenciaRepository.deleteById(id);
    }
}
