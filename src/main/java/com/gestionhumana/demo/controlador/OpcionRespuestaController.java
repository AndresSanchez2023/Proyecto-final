package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.OpcionRespuesta;
import com.gestionhumana.demo.servicio.OpcionRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opciones-respuesta")
public class OpcionRespuestaController {

    @Autowired
    private OpcionRespuestaService opcionRespuestaService;

    @PostMapping
    public ResponseEntity<OpcionRespuesta> createOpcionRespuesta(@RequestBody OpcionRespuesta opcionRespuesta) {
        OpcionRespuesta savedOpcion = opcionRespuestaService.saveOpcionRespuesta(opcionRespuesta);
        return ResponseEntity.ok(savedOpcion);
    }

    @GetMapping
    public List<OpcionRespuesta> getAllOpcionesRespuesta() {
        return opcionRespuestaService.findAllOpcionesRespuesta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpcionRespuesta> getOpcionRespuestaById(@PathVariable Long id) {
        Optional<OpcionRespuesta> opcionRespuesta = opcionRespuestaService.findById(id);
        return opcionRespuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/question/{questionId}")
    public List<OpcionRespuesta> getOpcionesByQuestionId(@PathVariable Long questionId) {
        return opcionRespuestaService.findByQuestionId(questionId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpcionRespuesta(@PathVariable Long id) {
        Optional<OpcionRespuesta> opcionRespuesta = opcionRespuestaService.findById(id);
        if (opcionRespuesta.isPresent()) {
            opcionRespuestaService.deleteOpcionRespuesta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

