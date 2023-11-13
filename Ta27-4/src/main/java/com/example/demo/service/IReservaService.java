package com.example.demo.service;

import com.example.demo.dto.Reserva;
import java.util.List;

public interface IReservaService {
	List<Reserva> getAllReservas();

    Reserva getReservaById(String id);

    Reserva createReserva(Reserva reserva);

    Reserva updateReserva(Reserva reserva);

    void deleteReserva(String id);
}
