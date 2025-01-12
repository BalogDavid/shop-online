package com.example.shoponline.service;

import java.util.List;
import com.example.shoponline.entities.Produs;

public interface ProdusService {
    Produs adaugaProdus(Produs produs); // Adds a product (including image)
    List<Produs> getAllProduse();      // Fetches all products (with images)

    Produs getProdusById(Long id);
}