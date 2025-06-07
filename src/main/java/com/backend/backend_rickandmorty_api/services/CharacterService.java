package com.backend.backend_rickandmorty_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.backend_rickandmorty_api.models.RickCharacter;

import java.util.*;

// Servicio encargado de consumir la API externa de Rick and Morty.
@Service
public class CharacterService {

    private final String BASE_URL = "https://rickandmortyapi.com/api/character/";

    @Autowired
    private RestTemplate restTemplate;

    public List<RickCharacter> getAllCharacters() {
        // Se consume la primera página
        Map<String, Object> response = restTemplate.getForObject(BASE_URL, Map.class);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

        // Convertimos cada resultado a un character
        List<RickCharacter> characters = new ArrayList<>();

        for (Map<String, Object> result : results) {
            RickCharacter character = restTemplate.getForObject(result.get("url").toString(), RickCharacter.class);
            characters.add(character);
        }

        return characters;
    }
    
    // Se obtiene un character por su ID desde la api
    public RickCharacter getCharacterById(int id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, RickCharacter.class);
    }
}
