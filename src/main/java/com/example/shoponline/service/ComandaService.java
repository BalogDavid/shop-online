package com.example.shoponline.service;

import com.example.shoponline.entities.Comanda;
import java.util.List;

public interface ComandaService {
    Comanda creeazaComanda(Long userId);
    List<Comanda> getComenziUtilizator(Long userId);
}