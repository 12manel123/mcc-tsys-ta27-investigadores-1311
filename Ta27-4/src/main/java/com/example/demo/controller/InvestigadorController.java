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

import com.example.demo.dto.Investigador;
import com.example.demo.service.IFacultadService;
import com.example.demo.service.IInvestigadorService;

@RestController
@RequestMapping("/investigador")
public class InvestigadorController {

    @Autowired
    private IInvestigadorService investigadorService;
    
    @Autowired
    private IFacultadService facultadService;

    @GetMapping
    public ResponseEntity<List<Investigador>> getAllInvestigadores() {
        List<Investigador> investigadores = investigadorService.getAllInvestigadores();
        return new ResponseEntity<>(investigadores, HttpStatus.OK);
    }
    

    @GetMapping("/{DNI}")
    public ResponseEntity<Investigador> getInvestigadorById(@PathVariable String DNI) {
        Investigador investigador = investigadorService.getInvestigadorByDNI(DNI);
        return new ResponseEntity<>(investigador, investigador != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<Investigador> createInvestigador(@RequestBody Investigador investigador,Integer facultad) {
    	investigador.setFacultad(facultadService.getFacultadByCodigo(facultad));
        Investigador createdInvestigador = investigadorService.createInvestigador(investigador);
        return new ResponseEntity<>(createdInvestigador, HttpStatus.CREATED);
    }

    @PutMapping("/{DNI}")
    public ResponseEntity<Investigador> updateInvestigador(@PathVariable String DNI, Integer facultad, @RequestBody Investigador investigador) {
        investigador.setNomApels(investigador.getNomApels());
    	investigador.setFacultad(facultadService.getFacultadByCodigo(facultad));
        Investigador updatedInvestigador = investigadorService.updateInvestigador(investigador);
        return new ResponseEntity<>(updatedInvestigador, updatedInvestigador != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{DNI}")
    public ResponseEntity<Void> deleteInvestigador(@PathVariable String DNI) {
        investigadorService.deleteInvestigador(DNI);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}