package com.tingeso.ms_5.repositories;

import com.tingeso.ms_5.DTO.SeguimientoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguimientoRepository extends JpaRepository<SeguimientoDTO, Long> {

}
