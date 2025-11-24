package com.castilloInfinito.repository;

import com.castilloInfinito.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
