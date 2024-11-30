package com.gestionhumana.demo.controlador;

import com.gestionhumana.demo.modelo.UsuarioNormal;
import com.gestionhumana.demo.servicio.UsuarioNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuariosnormales")
public class UsuarioNormalController {


    @Autowired
    private UsuarioNormalService usuarioNormalService;


    @PostMapping
    public ResponseEntity<UsuarioNormal> createUsuarioNormal(@RequestBody UsuarioNormal usuarioNormal) {
        UsuarioNormal savedUsuarioNormal = usuarioNormalService.saveUsuarioNormal(usuarioNormal);
        return ResponseEntity.ok(savedUsuarioNormal);
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<UsuarioNormal> getUsuarioByUsername(@PathVariable Long numeroDocumento) {
        Optional<UsuarioNormal> usuarioNormal = usuarioNormalService.findByNumeroDocumento(numeroDocumento);
        return usuarioNormal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
