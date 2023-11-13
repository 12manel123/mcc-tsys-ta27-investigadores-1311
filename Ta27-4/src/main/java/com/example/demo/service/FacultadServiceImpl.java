package com.example.demo.service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultadServiceImpl implements IFacultadService {

    @Autowired
    private IFacultadDAO facultadDAO;

    @Override
    public List<Facultad> getAllFacultades() {
        return facultadDAO.findAll();
    }

    @Override
    public Facultad getFacultadByCodigo(int codigo) {
        return facultadDAO.findById(codigo).orElse(null);
    }

    @Override
    public Facultad createFacultad(Facultad facultad) {
        return facultadDAO.save(facultad);
    }

    @Override
    public Facultad updateFacultad(Facultad facultad) {
        return facultadDAO.save(facultad);
    }

    @Override
    public void deleteFacultad(int codigo) {
        facultadDAO.deleteById(codigo);
    }
}
