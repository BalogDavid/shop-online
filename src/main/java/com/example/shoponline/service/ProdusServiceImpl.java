package com.example.shoponline.service;

import com.example.shoponline.entities.Produs;
import com.example.shoponline.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusServiceImpl implements ProdusService {
    private final ProdusRepository produsRepository;

    @Autowired
    public ProdusServiceImpl(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    @Override
    public Produs adaugaProdus(Produs produs) {
        // Saves a product, now including the `imagine` field
        return produsRepository.save(produs);
    }

    @Override
    public List<Produs> getAllProduse() {
        // Fetches all products, including the `imagine` field
        return produsRepository.findAll();
    }

    @Override
    public Produs getProdusById(Long id) {
        return null;
    }
}