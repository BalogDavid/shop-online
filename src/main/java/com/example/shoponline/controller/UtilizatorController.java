package com.example.shoponline.controller;

import com.example.shoponline.entities.Utilizator;
import com.example.shoponline.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilizatori")
public class UtilizatorController {

    private final UtilizatorService utilizatorService;

    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @PostMapping
    public ResponseEntity<Utilizator> inregistreazaUtilizator(@RequestBody Utilizator utilizator) {
        return ResponseEntity.ok(utilizatorService.inregistreazaUtilizator(utilizator));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilizator> getUtilizator(@PathVariable Long id) {
        return ResponseEntity.ok(utilizatorService.getUtilizatorById(id));
    }
}
