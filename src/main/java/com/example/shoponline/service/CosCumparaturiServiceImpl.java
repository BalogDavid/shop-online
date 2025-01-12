package com.example.shoponline.service;

import com.example.shoponline.entities.CosCumparaturi;
import com.example.shoponline.entities.Produs;
import com.example.shoponline.entities.Utilizator;
import com.example.shoponline.repository.CosCumparaturiRepository;
import com.example.shoponline.repository.ProdusRepository;
import com.example.shoponline.repository.UtilizatorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CosCumparaturiServiceImpl implements CosCumparaturiService {

    private final CosCumparaturiRepository cosCumparaturiRepository;
    private final ProdusRepository produsRepository;
    private final UtilizatorRepository utilizatorRepository;

    public CosCumparaturiServiceImpl(CosCumparaturiRepository cosCumparaturiRepository,
                                     ProdusRepository produsRepository,
                                     UtilizatorRepository utilizatorRepository) {
        this.cosCumparaturiRepository = cosCumparaturiRepository;
        this.produsRepository = produsRepository;
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public void adaugaProdus(Long produsId, Long utilizatorId) {
        // Fetch the user
        Optional<Utilizator> optionalUtilizator = utilizatorRepository.findById(utilizatorId);
        if (optionalUtilizator.isEmpty()) {
            throw new IllegalArgumentException("Utilizator not found!");
        }
        Utilizator utilizator = optionalUtilizator.get();

        // Fetch the product
        Optional<Produs> optionalProdus = produsRepository.findById(produsId);
        if (optionalProdus.isEmpty()) {
            throw new IllegalArgumentException("Produs not found!");
        }
        Produs produs = optionalProdus.get();

        // Get the user's shopping cart list
        List<CosCumparaturi> cosCumparaturiList = utilizator.getCosCumparaturiList();

        // Check if the user already has a cart, or create a new one
        CosCumparaturi cosCumparaturi;
        if (cosCumparaturiList == null || cosCumparaturiList.isEmpty()) {
            cosCumparaturi = new CosCumparaturi(utilizator);
            utilizator.setCosCumparaturiList(new ArrayList<>());
            utilizator.getCosCumparaturiList().add(cosCumparaturi);
        } else {
            // Assuming we want to work with the first cart
            cosCumparaturi = cosCumparaturiList.get(0);
        }

        // Add the product to the cart
        List<Produs> produse = cosCumparaturi.getProduse();
        if (produse == null) {
            produse = new ArrayList<>();
            cosCumparaturi.setProduse(produse);
        }
        produse.add(produs);

        // Save the cart (and cascade updates to the products)
        cosCumparaturiRepository.save(cosCumparaturi);
    }

    @Override
    public List<Produs> veziCos(Long utilizatorId) {
        // Fetch the user
        Optional<Utilizator> optionalUtilizator = utilizatorRepository.findById(utilizatorId);
        if (optionalUtilizator.isEmpty()) {
            throw new IllegalArgumentException("Utilizator not found!");
        }
        Utilizator utilizator = optionalUtilizator.get();

        // Get the user's shopping cart list
        List<CosCumparaturi> cosCumparaturiList = utilizator.getCosCumparaturiList();

        if (cosCumparaturiList == null || cosCumparaturiList.isEmpty()) {
            throw new IllegalArgumentException("No carts found for this user!");
        }

        // Assuming we want to use the first cart in the list
        CosCumparaturi cosCumparaturi = cosCumparaturiList.get(0);

        // Return the list of products in the user's cart
        return cosCumparaturi.getProduse() != null ? cosCumparaturi.getProduse() : new ArrayList<>();
    }
}