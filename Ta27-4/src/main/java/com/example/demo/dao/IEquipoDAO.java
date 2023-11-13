package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, String> {
}