package com.castilloInfinito.service.impl;

import com.castilloInfinito.dto.MensajeCrearRequest;
import com.castilloInfinito.dto.MensajeReconstruirRequest;
import com.castilloInfinito.entity.Mensaje;
import com.castilloInfinito.exception.RecursoNoEncontradoException;
import com.castilloInfinito.repository.MensajeRepository;
import com.castilloInfinito.service.MensajeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MensajeServiceImpl implements MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public Mensaje crearMensaje(MensajeCrearRequest request) {
        if (request.getPilarId() == null) {
            throw new IllegalArgumentException("El pilarId es obligatorio");
        }
        if (request.getContenidoFragmentado() == null || request.getContenidoFragmentado().isEmpty()) {
            throw new IllegalArgumentException("El contenido fragmentado no puede estar vacío");
        }
        Mensaje mensaje = new Mensaje();
        mensaje.setPilarId(request.getPilarId());
        mensaje.setContenidoFragmentado(request.getContenidoFragmentado());
        return mensajeRepository.save(mensaje);
    }

    @Override
    public Mensaje reconstruirMensaje(Long id, MensajeReconstruirRequest request) {
        if (request.getContenidoReconstruido() == null || request.getContenidoReconstruido().isEmpty()) {
            throw new IllegalArgumentException("El contenido reconstruido no puede estar vacío");
        }
        Mensaje mensaje = mensajeRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Mensaje no encontrado con id " + id));
        mensaje.setContenidoReconstruido(request.getContenidoReconstruido());
        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> listarTodos() {
        return mensajeRepository.findAll();
    }

    @Override
    public Mensaje obtenerPorId(Long id) {
        return mensajeRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Mensaje no encontrado con id " + id));
    }
}
