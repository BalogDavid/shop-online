package com.example.shoponline.controller;

import com.example.shoponline.entities.Utilizator;
import com.example.shoponline.service.UtilizatorService;
import com.example.shoponline.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UtilizatorService utilizatorService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder; // For hashing and verifying passwords

    // User login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilizator loginRequest) {
        try {
            Utilizator user = utilizatorService.findByEmail(loginRequest.getEmail());
            if (user == null) {
                return ResponseEntity.status(401).body("Invalid email or password");
            }

            // Validate the hashed password against the plain text one
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(401).body("Invalid email or password");
            }

            // Generate JWT token
            String token = jwtService.generateToken(user);

            // Create response
            Map<String, Object> response = new HashMap<>();
            response.put("userId", user.getId());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // User signup
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Utilizator signupRequest) {
        try {
            // Check if the email is already registered
            if (utilizatorService.findByEmail(signupRequest.getEmail()) != null) {
                return ResponseEntity.status(409).body("User with this email already exists");
            }

            // Hash and save the password in the database
            signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            Utilizator newUser = utilizatorService.inregistreazaUtilizator(signupRequest);

            return ResponseEntity.status(201).body("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}