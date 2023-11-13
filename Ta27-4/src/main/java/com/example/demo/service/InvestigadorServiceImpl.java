package com.example.demo.service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService {

    @Autowired
    private IInvestigadorDAO investigadorDAO;

    @Override
    public List<Investigador> getAllInvestigadores() {
        return investigadorDAO.findAll();
    }

    @Override
    public Investigador getInvestigadorByDNI(String DNI) {
        return investigadorDAO.findById(DNI).orElse(null);
    }

    @Override
    public Investigador createInvestigador(Investigador investigador) {
        System.out.println("Creando investigador en el servicio: " + investigador);
        Investigador createdInvestigador = investigadorDAO.save(investigador);
        System.out.println("Investigador creado en el servicio: " + createdInvestigador);
        return createdInvestigador;
    }

    @Override
    public Investigador updateInvestigador(Investigador investigador) {
        return investigadorDAO.save(investigador);
    }

    @Override
    public void deleteInvestigador(String DNI) {
        investigadorDAO.deleteById(DNI);
    }
}
