package com.example.demo.service;

import com.example.demo.dto.Facultad;
import java.util.List;

public interface IFacultadService {
    List<Facultad> getAllFacultades();
    Facultad getFacultadByCodigo(int codigo);
    Facultad createFacultad(Facultad facultad);
    Facultad updateFacultad(Facultad facultad);
    void deleteFacultad(int codigo);
}
