package com.castilloInfinito.controller;

import com.castilloInfinito.dto.TriangulacionResponseDTO;
import com.castilloInfinito.service.InteligenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inteligencia")
@CrossOrigin(origins = "*")
public class InteligenciaController {

    private final InteligenciaService inteligenciaService;

    public InteligenciaController(InteligenciaService inteligenciaService) {
        this.inteligenciaService = inteligenciaService;
    }

    @GetMapping("/triangulacion")
    public ResponseEntity<TriangulacionResponseDTO> obtenerTriangulacion() {
        TriangulacionResponseDTO resp = inteligenciaService.calcularTriangulacion();
        return ResponseEntity.ok(resp);
    }
}
