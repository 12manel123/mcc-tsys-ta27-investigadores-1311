package com.example.demo.controller;

import com.example.demo.dto.Reserva;
import com.example.demo.service.IEquipoService;
import com.example.demo.service.IInvestigadorService;
import com.example.demo.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;
    @Autowired
    private IInvestigadorService investigadorService;
    @Autowired
    private IEquipoService equipoService;


    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.getAllReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable String id) {
        Reserva reserva = reservaService.getReservaById(id);
        return new ResponseEntity<>(reserva, reserva != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva,String DNI,String codigo) {
    	System.out.println("Investeigoador: "+investigadorService.getInvestigadorByDNI(DNI));
    	reserva.setInvestigador(investigadorService.getInvestigadorByDNI(DNI));
    	reserva.setEquipo(equipoService.getEquipoByNumSerie(codigo));
        Reserva createdReserva = reservaService.createReserva(reserva);
        return new ResponseEntity<>(createdReserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable String id, @RequestBody Reserva reserva,String DNI,String codigo) {
    	System.out.println("Investeigoador: "+investigadorService.getInvestigadorByDNI(DNI));
    	reserva.setInvestigador(investigadorService.getInvestigadorByDNI(DNI));
    	reserva.setEquipo(equipoService.getEquipoByNumSerie(codigo));
        reserva.setId(id);
        Reserva updatedReserva = reservaService.updateReserva(reserva);
        return new ResponseEntity<>(updatedReserva, updatedReserva != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable String id) {
    	if(reservaService.getReservaById(id)!=null) {
    		reservaService.deleteReserva(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
