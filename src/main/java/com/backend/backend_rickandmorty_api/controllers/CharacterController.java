package com.backend.backend_rickandmorty_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend_rickandmorty_api.models.RickCharacter;
import com.backend.backend_rickandmorty_api.services.CharacterService;

/**
 * Controlador REST que expone endpoints para acceder a personajes
 * de la api de Rick and Morty a través de nuestro backend.
 */
@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*")
public class CharacterController {
    
    @Autowired
    private CharacterService characterService;

    // GET: /api/characters
    @GetMapping
    public List<RickCharacter> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    // GET: /api/characters/{id}
    @GetMapping("/{id}")
    public RickCharacter getCharacterById(@PathVariable int id) {
        return characterService.getCharacterById(id);
    }
}
