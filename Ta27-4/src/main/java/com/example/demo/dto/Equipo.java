package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipo {
	@Id
    private String numSerie;

    private String nombre;


    @ManyToOne
    @JoinColumn(name = "facultad")
    @JsonIgnore 
    private Facultad facultad;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore 
    private List<Reserva> reservas;

    // Constructores
    public Equipo() {
    }

    public Equipo(String numSerie, String nombre, Facultad facultad) {
        this.numSerie = numSerie;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    // Getters y Setters

    @Override
    public String toString() {
        return "Equipo{" +
                "numSerie='" + numSerie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", facultad=" + facultad +
                '}';
    }

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
    
}
