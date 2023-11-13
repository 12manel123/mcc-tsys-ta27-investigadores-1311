package com.example.demo.service;

import com.example.demo.dto.Equipo;
import java.util.List;

public interface IEquipoService {
    List<Equipo> getAllEquipos();
    Equipo getEquipoByNumSerie(String numSerie);
    Equipo createEquipo(Equipo equipo);
    Equipo updateEquipo(Equipo equipo);
    void deleteEquipo(String numSerie);
}
