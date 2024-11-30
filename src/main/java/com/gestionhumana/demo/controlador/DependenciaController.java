package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.Dependencia;
import com.gestionhumana.demo.servicio.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/dependencias")
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;

    @PostMapping
    public ResponseEntity<Dependencia> createDependencia(@RequestBody Dependencia dependencia) {
        Dependencia savedDependencia = dependenciaService.saveDependencia(dependencia);
        return ResponseEntity.ok(savedDependencia);
    }

    @GetMapping
    public List<Dependencia> getAllDependencias() {
        return dependenciaService.findAllDependencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependencia> getDependenciaById(@PathVariable Long id) {
        Optional<Dependencia> dependencia = dependenciaService.findById(id);
        return dependencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Dependencia> getDependenciaByName(@PathVariable String name) {
        Dependencia dependencia = dependenciaService.findByName(name);
        if (dependencia != null) {
            return ResponseEntity.ok(dependencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dependencia> updateDependencia(@PathVariable Long id, @RequestBody Dependencia dependenciaDetails) {
        Optional<Dependencia> dependencia = dependenciaService.findById(id);
        if (dependencia.isPresent()) {
            Dependencia updatedDependencia = dependenciaService.saveDependencia(dependenciaDetails);
            return ResponseEntity.ok(updatedDependencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDependencia(@PathVariable Long id) {
        Optional<Dependencia> dependencia = dependenciaService.findById(id);
        if (dependencia.isPresent()) {
            dependenciaService.deleteDependencia(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
