package com.example.shoponline.service;

import com.example.shoponline.entities.Comanda;
import com.example.shoponline.entities.Utilizator;
import com.example.shoponline.repository.ComandaRepository;
import com.example.shoponline.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComandaServiceImpl implements ComandaService {
    private final ComandaRepository comandaRepository;
    private final UtilizatorRepository utilizatorRepository;

    @Autowired
    public ComandaServiceImpl(ComandaRepository comandaRepository, UtilizatorRepository utilizatorRepository) {
        this.comandaRepository = comandaRepository;
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public Comanda creeazaComanda(Long userId) {
        Utilizator utilizator = utilizatorRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilizatorul nu a fost găsit"));
        Comanda comanda = new Comanda(utilizator, LocalDate.now());
        return comandaRepository.save(comanda);
    }

    @Override
    public List<Comanda> getComenziUtilizator(Long userId) {
        return comandaRepository.findByUtilizatorId(userId);
    }
}
