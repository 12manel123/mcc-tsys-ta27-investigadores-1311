package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Reserva;
import java.util.List;

public interface IReservaDAO extends JpaRepository<Reserva, String> {
    List<Reserva> findAllByInvestigadorDNI(String DNI);
    List<Reserva> findAllByEquipoNumSerie(String numSerie);
    Reserva findByInvestigadorDNIAndEquipoNumSerie(String DNI, String numSerie);
    void deleteByInvestigador_DNIAndEquipo_NumSerie(String DNI, String numSerie);
}
