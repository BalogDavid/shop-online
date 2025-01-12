package com.example.shoponline.service;

import com.example.shoponline.entities.Utilizator;
import com.example.shoponline.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilizatorServiceImpl implements UtilizatorService {
    private final UtilizatorRepository utilizatorRepository;

    @Autowired
    public UtilizatorServiceImpl(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public Utilizator inregistreazaUtilizator(Utilizator utilizator) {
        // Check if the email is already registered
        if (utilizatorRepository.existsByEmail(utilizator.getEmail())) {
            throw new RuntimeException("A user with this email already exists");
        }

        // Save the new user to the database
        return utilizatorRepository.save(utilizator);
    }

    @Override
    public Utilizator getUtilizatorById(Long id) {
        return utilizatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Utilizator findByEmail(String email) {
        // Safe handling with Optional
        return utilizatorRepository.findByEmail(email)
                .orElse(null); // Return null if no user is found
    }
}