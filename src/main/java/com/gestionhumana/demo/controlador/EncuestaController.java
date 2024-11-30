package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.servicio.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @PostMapping
    public ResponseEntity<Encuesta> createEncuesta(@RequestBody Encuesta encuesta) {
        Encuesta savedEncuesta = encuestaService.saveEncuesta(encuesta);
        return ResponseEntity.ok(savedEncuesta);
    }

    @GetMapping
    public List<Encuesta> getAllEncuestas() {
        return encuestaService.findAllEncuestas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encuesta> getEncuestaById(@PathVariable Long id) {
        Optional<Encuesta> encuesta = encuestaService.findById(id);
        return encuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/admin/{adminId}")
    public List<Encuesta> getEncuestasByAdminId(@PathVariable Long adminId) {
        return encuestaService.findByAdminId(adminId);
    }

    @GetMapping("/enabled/{isEnabled}")
    public List<Encuesta> getEncuestasByIsEnabled(@PathVariable Boolean isEnabled) {
        return encuestaService.findByIsEnabled(isEnabled);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncuesta(@PathVariable Long id) {
        Optional<Encuesta> encuesta = encuestaService.findById(id);
        if (encuesta.isPresent()) {
            encuestaService.deleteEncuesta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
