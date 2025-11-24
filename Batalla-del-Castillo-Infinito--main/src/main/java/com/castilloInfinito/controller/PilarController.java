package com.castilloInfinito.controller;

import com.castilloInfinito.dto.ActualizarPosicionRequest;
import com.castilloInfinito.dto.ErrorResponse;
import com.castilloInfinito.dto.PilarDetalleDTO;
import com.castilloInfinito.dto.PilarRequestDTO;
import com.castilloInfinito.service.PilarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {

    private final PilarService pilarService;

    public PilarController(PilarService pilarService) {
        this.pilarService = pilarService;
    }

    @PostMapping
    public ResponseEntity<PilarDetalleDTO> crear(@RequestBody PilarRequestDTO request) {
        return ResponseEntity.ok(pilarService.crearPilar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilarDetalleDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pilarService.obtenerPilarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PilarDetalleDTO>> listar() {
        return ResponseEntity.ok(pilarService.listarPilares());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PilarDetalleDTO> actualizar(@PathVariable Long id, @RequestBody PilarRequestDTO request) {
        return ResponseEntity.ok(pilarService.actualizarPilar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pilarService.eliminarPilar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/posicion")
    public ResponseEntity<PilarDetalleDTO> actualizarPosicion(@RequestBody ActualizarPosicionRequest request) {
        return ResponseEntity.ok(pilarService.actualizarPosicion(request));
    }

    // ====== MANEJO GLOBAL DE ERRORES ======
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> manejarErrores(RuntimeException ex) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse("error", ex.getMessage())
        );
    }
}
