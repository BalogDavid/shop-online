package com.example.shoponline.controller;

import com.example.shoponline.entities.Produs;
import com.example.shoponline.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    @GetMapping("/{id}")
    public Produs getProdusById(@PathVariable Long id) {
        return produsService.getProdusById(id);
    }
}