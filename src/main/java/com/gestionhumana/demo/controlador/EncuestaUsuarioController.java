package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.Encuesta;
import com.gestionhumana.demo.modelo.EncuestaUsuario;
import com.gestionhumana.demo.modelo.UsuarioNormal;
import com.gestionhumana.demo.servicio.EncuestaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encuestas-usuarios")
public class EncuestaUsuarioController {

    @Autowired
    private EncuestaUsuarioService encuestaUsuarioService;

    @PostMapping
    public ResponseEntity<EncuestaUsuario> createEncuestaUsuario(@RequestBody EncuestaUsuario encuestaUsuario) {
        EncuestaUsuario savedEncuestaUsuario = encuestaUsuarioService.saveEncuestaUsuario(encuestaUsuario);
        return ResponseEntity.ok(savedEncuestaUsuario);
    }

    @GetMapping
    public List<EncuestaUsuario> getAllEncuestaUsuarios() {
        return encuestaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncuestaUsuario> getEncuestaUsuarioById(@PathVariable Long id) {
        Optional<EncuestaUsuario> encuestaUsuario = encuestaUsuarioService.findById(id);
        return encuestaUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/user/{userId}/survey/{surveyId}")
    public ResponseEntity<EncuestaUsuario> getEncuestaUsuarioByUserAndSurvey(@PathVariable Long userId, @PathVariable Long surveyId) {
        UsuarioNormal user = new UsuarioNormal();
        user.setId(userId);

        Encuesta survey = new Encuesta();
        survey.setId(surveyId);

        EncuestaUsuario encuestaUsuario = encuestaUsuarioService.findByUserAndSurvey(user, survey);
        return (encuestaUsuario != null) ? ResponseEntity.ok(encuestaUsuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncuestaUsuario(@PathVariable Long id) {
        Optional<EncuestaUsuario> encuestaUsuario = encuestaUsuarioService.findById(id);
        if (encuestaUsuario.isPresent()) {
            encuestaUsuarioService.deleteEncuestaUsuario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}