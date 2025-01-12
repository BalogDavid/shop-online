package com.example.shoponline.controller;

import com.example.shoponline.entities.CosCumparaturi;
import com.example.shoponline.entities.Produs;
import com.example.shoponline.service.CosCumparaturiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cos")
public class CosCumparaturiController {
    private final CosCumparaturiService cosCumparaturiService;

    @Autowired
    public CosCumparaturiController(CosCumparaturiService cosCumparaturiService) {
        this.cosCumparaturiService = cosCumparaturiService;
    }

    @PostMapping("/adauga")
    public ResponseEntity<String> adaugaProdusInCos(@RequestParam Long produsId, @RequestParam Long utilizatorId) {
        cosCumparaturiService.adaugaProdus(produsId, utilizatorId);
        return ResponseEntity.ok("Produs adaugat in cos cu succes!");
    }

    @GetMapping("/{utilizatorId}")
    public ResponseEntity<List<Produs>> veziCos(@PathVariable Long utilizatorId) {
        return ResponseEntity.ok(cosCumparaturiService.veziCos(utilizatorId));
    }
}
