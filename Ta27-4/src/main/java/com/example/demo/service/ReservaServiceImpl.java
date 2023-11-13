package com.example.demo.service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
    private IReservaDAO reservaDAO;

    @Override
    public List<Reserva> getAllReservas() {
        return reservaDAO.findAll();
    }

    @Override
    public Reserva getReservaById(String id) {
        return reservaDAO.findById(id).orElse(null);
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return reservaDAO.save(reserva);
    }

    @Override
    public Reserva updateReserva(Reserva reserva) {
        return reservaDAO.save(reserva);
    }

    @Override
    public void deleteReserva(String id) {
        reservaDAO.deleteById(id);
    }
}
