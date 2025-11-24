package com.castilloInfinito.controller;

import com.castilloInfinito.dto.MensajeCrearRequest;
import com.castilloInfinito.dto.MensajeReconstruirRequest;
import com.castilloInfinito.entity.Mensaje;
import com.castilloInfinito.service.MensajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearMensaje(@RequestBody MensajeCrearRequest request) {
        return ResponseEntity.status(201).body(mensajeService.crearMensaje(request));
    }

    @PutMapping("/{id}/reconstruir")
    public ResponseEntity<Mensaje> reconstruirMensaje(
            @PathVariable Long id,
            @RequestBody MensajeReconstruirRequest request) {
        return ResponseEntity.ok(mensajeService.reconstruirMensaje(id, request));
    }

    @GetMapping
    public ResponseEntity<List<Mensaje>> listarMensajes() {
        return ResponseEntity.ok(mensajeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtenerMensaje(@PathVariable Long id) {
        return ResponseEntity.ok(mensajeService.obtenerPorId(id));
    }
}
