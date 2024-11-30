package com.gestionhumana.demo.servicio;

import com.gestionhumana.demo.modelo.Dependencia;

import java.util.List;
import java.util.Optional;

public interface DependenciaService {

    Dependencia saveDependencia(Dependencia dependencia);

    Optional<Dependencia> findById(Long id);

    List<Dependencia> findAllDependencias();

    Dependencia findByName(String name);

    void deleteDependencia(Long id);
}
