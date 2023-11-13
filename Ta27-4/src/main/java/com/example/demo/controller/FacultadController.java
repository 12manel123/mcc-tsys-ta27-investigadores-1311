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

import com.example.demo.dto.Facultad;
import com.example.demo.service.IFacultadService;

@RestController
@RequestMapping("/facultad")
public class FacultadController {
	@Autowired
    private IFacultadService facultadService;

    @GetMapping
    public ResponseEntity<List<Facultad>> getAllFacultades() {
        List<Facultad> facultades = facultadService.getAllFacultades();
        return new ResponseEntity<>(facultades, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Facultad> getFacultadById(@PathVariable int codigo) {
        Facultad facultad = facultadService.getFacultadByCodigo(codigo);
        return new ResponseEntity<>(facultad, facultad != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Facultad> createFacultad(@RequestBody Facultad facultad) {
        Facultad createdFacultad = facultadService.createFacultad(facultad);
        return new ResponseEntity<>(createdFacultad, HttpStatus.CREATED);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Facultad> updateFacultad(@PathVariable int codigo, @RequestBody Facultad facultad) {
        facultad.setCodigo(codigo);
        Facultad updatedFacultad = facultadService.updateFacultad(facultad);
        return new ResponseEntity<>(updatedFacultad, updatedFacultad != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteFacultad(@PathVariable int codigo) {
        facultadService.deleteFacultad(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
