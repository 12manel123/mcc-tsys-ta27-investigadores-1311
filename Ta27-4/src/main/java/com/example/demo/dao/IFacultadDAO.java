package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Facultad;

public interface IFacultadDAO extends JpaRepository<Facultad, Integer> {
}