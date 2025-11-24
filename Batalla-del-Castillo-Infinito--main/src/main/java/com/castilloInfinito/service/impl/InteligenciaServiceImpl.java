package com.castilloInfinito.service.impl;

import com.castilloInfinito.dto.TriangulacionResponseDTO;
import com.castilloInfinito.entity.Pilar;
import com.castilloInfinito.repository.PilarRepository;
import com.castilloInfinito.service.InteligenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteligenciaServiceImpl implements InteligenciaService {

    private final PilarRepository pilarRepository;

    public InteligenciaServiceImpl(PilarRepository pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

    @Override
    public TriangulacionResponseDTO calcularTriangulacion() {

        List<Pilar> pilares = pilarRepository.findAll();

        if (pilares.isEmpty()) {
            // puedes lanzar excepción o devolver algo neutro
            TriangulacionResponseDTO respVacia = new TriangulacionResponseDTO();
            respVacia.setDescripcion("No hay suficientes datos de pilares para estimar la posición de Muzan");
            respVacia.setNivelConfianza(0.0);
            return respVacia;
        }

        double sumaX = 0;
        double sumaY = 0;

        for (Pilar p : pilares) {
            sumaX += p.getPosX();
            sumaY += p.getPosY();
        }

        int xProm = (int) Math.round(sumaX / pilares.size());
        int yProm = (int) Math.round(sumaY / pilares.size());

        TriangulacionResponseDTO.Coordenada coord =
                new TriangulacionResponseDTO.Coordenada(xProm, yProm);

        TriangulacionResponseDTO resp = new TriangulacionResponseDTO();
        resp.setPosiblePosicionMuzan(coord);
        resp.setNivelConfianza(0.78);
        resp.setDescripcion("Probabilidad alta de presencia demoníaca en las coordenadas dadas");

        return resp;
    }
}
