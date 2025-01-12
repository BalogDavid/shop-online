package com.example.shoponline.service;

import com.example.shoponline.entities.CosCumparaturi;
import com.example.shoponline.entities.Produs;
import java.util.List;

public interface CosCumparaturiService {
    void adaugaProdus(Long produsId, Long utilizatorId);
    List<Produs> veziCos(Long utilizatorId);
}
