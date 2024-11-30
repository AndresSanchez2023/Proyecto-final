package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.RespuestaUsuario;
import com.gestionhumana.demo.servicio.RespuestaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas-usuario")
public class RespuestaUsuarioController {

    @Autowired
    private RespuestaUsuarioService respuestaUsuarioService;

    @PostMapping
    public ResponseEntity<RespuestaUsuario> createRespuestaUsuario(@RequestBody RespuestaUsuario respuestaUsuario) {
        RespuestaUsuario savedRespuesta = respuestaUsuarioService.saveRespuestaUsuario(respuestaUsuario);
        return ResponseEntity.ok(savedRespuesta);
    }

    @GetMapping
    public List<RespuestaUsuario> getAllRespuestasUsuario() {
        return respuestaUsuarioService.findAllRespuestas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> getRespuestaUsuarioById(@PathVariable Long id) {
        Optional<RespuestaUsuario> respuestaUsuario = respuestaUsuarioService.findById(id);
        return respuestaUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user-survey/{userSurveyId}")
    public List<RespuestaUsuario> getRespuestasByUserSurveyId(@PathVariable Long userSurveyId) {
        return respuestaUsuarioService.findByUserSurveyId(userSurveyId);
    }

    @GetMapping("/question/{questionId}")
    public List<RespuestaUsuario> getRespuestasByQuestionId(@PathVariable Long questionId) {
        return respuestaUsuarioService.findByQuestionId(questionId);
    }

    @GetMapping("/user-survey/{userSurveyId}/question/{questionId}")
    public List<RespuestaUsuario> getRespuestasByUserSurveyAndQuestionId(
            @PathVariable Long userSurveyId,
            @PathVariable Long questionId) {
        return respuestaUsuarioService.findByUserSurveyIdAndQuestionId(userSurveyId, questionId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuestaUsuario(@PathVariable Long id) {
        Optional<RespuestaUsuario> respuestaUsuario = respuestaUsuarioService.findById(id);
        if (respuestaUsuario.isPresent()) {
            respuestaUsuarioService.deleteRespuestaUsuario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

