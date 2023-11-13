package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipo;
import com.example.demo.service.IEquipoService;
import com.example.demo.service.IFacultadService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    @Autowired
    private IFacultadService facultadService;


    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = equipoService.getAllEquipos();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/{numSerie}")
    public ResponseEntity<Equipo> getEquipoByNumSerie(@PathVariable String numSerie) {
        Equipo equipo = equipoService.getEquipoByNumSerie(numSerie);
        return new ResponseEntity<>(equipo, equipo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo,Integer facultad) {
    	equipo.setFacultad(facultadService.getFacultadByCodigo(facultad));
        Equipo createdEquipo = equipoService.createEquipo(equipo);
        return new ResponseEntity<>(createdEquipo, HttpStatus.CREATED);
    }

    @PutMapping("/{numSerie}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable String numSerie, @RequestBody Equipo equipo,Integer facultad) {
    	equipo.setFacultad(facultadService.getFacultadByCodigo(facultad));
        equipo.setNumSerie(numSerie);
        Equipo updatedEquipo = equipoService.updateEquipo(equipo);
        return new ResponseEntity<>(updatedEquipo, updatedEquipo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{numSerie}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable String numSerie) {
        equipoService.deleteEquipo(numSerie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}