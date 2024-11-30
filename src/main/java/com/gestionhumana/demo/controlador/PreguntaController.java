package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.Pregunta;
import com.gestionhumana.demo.servicio.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta) {
        Pregunta savedPregunta = preguntaService.savePregunta(pregunta);
        return ResponseEntity.ok(savedPregunta);
    }

    @GetMapping
    public List<Pregunta> getAllPreguntas() {
        return preguntaService.findAllPreguntas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable Long id) {
        Optional<Pregunta> pregunta = preguntaService.findById(id);
        return pregunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/survey/{surveyId}")
    public List<Pregunta> getPreguntasBySurveyId(@PathVariable Long surveyId) {
        return preguntaService.findBySurveyId(surveyId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable Long id) {
        Optional<Pregunta> pregunta = preguntaService.findById(id);
        if (pregunta.isPresent()) {
            preguntaService.deletePregunta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

