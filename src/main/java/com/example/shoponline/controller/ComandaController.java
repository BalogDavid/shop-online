package com.example.shoponline.controller;

import com.example.shoponline.entities.Comanda;
import com.example.shoponline.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comenzi")
public class ComandaController {
    private final ComandaService comandaService;

    @Autowired
    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Comanda> creeazaComanda(@PathVariable Long userId) {
        Comanda comandaNoua = comandaService.creeazaComanda(userId);
        return ResponseEntity.ok(comandaNoua);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Comanda>> getComenziUtilizator(@PathVariable Long userId) {
        return ResponseEntity.ok(comandaService.getComenziUtilizator(userId));
    }
}