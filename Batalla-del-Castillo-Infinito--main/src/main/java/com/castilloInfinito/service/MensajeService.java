package com.castilloInfinito.service;

import com.castilloInfinito.dto.MensajeCrearRequest;
import com.castilloInfinito.dto.MensajeReconstruirRequest;
import com.castilloInfinito.entity.Mensaje;

import java.util.List;

public interface MensajeService {

    Mensaje crearMensaje(MensajeCrearRequest request);

    Mensaje reconstruirMensaje(Long id, MensajeReconstruirRequest request);

    List<Mensaje> listarTodos();

    Mensaje obtenerPorId(Long id);
}
