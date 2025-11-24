package com.castilloInfinito.service;

import com.castilloInfinito.dto.ActualizarPosicionRequest;
import com.castilloInfinito.dto.PilarDetalleDTO;
import com.castilloInfinito.dto.PilarRequestDTO;

import java.util.List;

public interface PilarService {

    PilarDetalleDTO crearPilar(PilarRequestDTO request);

    PilarDetalleDTO obtenerPilarPorId(Long id);

    List<PilarDetalleDTO> listarPilares();

    PilarDetalleDTO actualizarPilar(Long id, PilarRequestDTO request);

    void eliminarPilar(Long id);

    PilarDetalleDTO actualizarPosicion(ActualizarPosicionRequest request);
}
