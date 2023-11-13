package com.example.demo.service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    private IEquipoDAO equipoDAO;

    @Override
    public List<Equipo> getAllEquipos() {
        return equipoDAO.findAll();
    }

    @Override
    public Equipo getEquipoByNumSerie(String numSerie) {
        return equipoDAO.findById(numSerie).orElse(null);
    }

    @Override
    public Equipo createEquipo(Equipo equipo) {
        return equipoDAO.save(equipo);
    }

    @Override
    public Equipo updateEquipo(Equipo equipo) {
        return equipoDAO.save(equipo);
    }

    @Override
    public void deleteEquipo(String numSerie) {
        equipoDAO.deleteById(numSerie);
    }
}