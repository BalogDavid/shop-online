package com.example.shoponline.service;

import com.example.shoponline.entities.Utilizator;

public interface UtilizatorService {
    Utilizator inregistreazaUtilizator(Utilizator utilizator);
    Utilizator getUtilizatorById(Long id);
    Utilizator findByEmail(String email);
}