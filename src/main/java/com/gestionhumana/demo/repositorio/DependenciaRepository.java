package com.gestionhumana.demo.repositorio;

import com.gestionhumana.demo.modelo.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Long> {

    Dependencia findByName(String name);

}
