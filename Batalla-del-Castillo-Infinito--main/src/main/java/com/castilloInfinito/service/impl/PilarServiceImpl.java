package com.castilloInfinito.service.impl;

import com.castilloInfinito.dto.ActualizarPosicionRequest;
import com.castilloInfinito.dto.PilarDetalleDTO;
import com.castilloInfinito.dto.PilarRequestDTO;
import com.castilloInfinito.entity.Pilar;
import com.castilloInfinito.repository.PilarRepository;
import com.castilloInfinito.service.PilarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PilarServiceImpl implements PilarService {

    private final PilarRepository repository;

    public PilarServiceImpl(PilarRepository repository) {
        this.repository = repository;
    }

    @Override
    public PilarDetalleDTO crearPilar(PilarRequestDTO request) {
        Pilar p = new Pilar();
        p.setNombre(request.getNombre());
        p.setPosX(request.getPosX());
        p.setPosY(request.getPosY());
        p.setEstado(request.getEstado());

        Pilar guardado = repository.save(p);
        return convertirADetalle(guardado);
    }

    @Override
    public PilarDetalleDTO obtenerPilarPorId(Long id) {
        Pilar p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El pilar no existe"));
        return convertirADetalle(p);
    }

    @Override
    public List<PilarDetalleDTO> listarPilares() {
        List<Pilar> pilares = repository.findAll();

        if (pilares.isEmpty()) {
            throw new RuntimeException("No hay pilares registrados");
        }

        return pilares.stream()
                .map(this::convertirADetalle)
                .collect(Collectors.toList());
    }

    @Override
    public PilarDetalleDTO actualizarPilar(Long id, PilarRequestDTO request) {
        Pilar p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pilar no encontrado"));

        p.setNombre(request.getNombre());
        p.setPosX(request.getPosX());
        p.setPosY(request.getPosY());
        p.setEstado(request.getEstado());

        repository.save(p);

        return convertirADetalle(p);
    }

    @Override
    public void eliminarPilar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pilar no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public PilarDetalleDTO actualizarPosicion(ActualizarPosicionRequest request) {
        Pilar p = repository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Pilar no encontrado"));

        p.setPosX(request.getPosX());
        p.setPosY(request.getPosY());

        repository.save(p);

        return convertirADetalle(p);
    }

    private PilarDetalleDTO convertirADetalle(Pilar p) {
        return new PilarDetalleDTO(
                p.getId(),
                p.getNombre(),
                p.getPosX(),
                p.getPosY(),
                p.getEstado()
        );
    }
}
