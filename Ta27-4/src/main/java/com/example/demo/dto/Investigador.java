package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//Investigador.java
@Entity
public class Investigador {
 @Id
 @Column(name = "dni")
 private String DNI;

 private String nomApels;

 @ManyToOne
 @JoinColumn(name = "facultad")
 @JsonIgnore 
 private Facultad facultad;

 @OneToMany(mappedBy = "investigador")
 @JsonIgnore 
 private List<Reserva> reservas;

 // Constructores
 public Investigador() {
 }

 public Investigador(String DNI, String nomApels, Facultad facultad) {
     this.DNI = DNI;
     this.nomApels = nomApels;
     this.facultad = facultad;
 }



 @Override
 public String toString() {
     return "Investigador{" +
             "DNI='" + DNI + '\'' +
             ", nomApels='" + nomApels + '\'' +
             ", facultad=" + facultad +
             '}';
 }
 // Getters y Setters

public String getDNI() {
	return DNI;
}

public void setDNI(String dni) {
	DNI = dni;
}

public String getNomApels() {
	return nomApels;
}

public void setNomApels(String nomApels) {
	this.nomApels = nomApels;
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
