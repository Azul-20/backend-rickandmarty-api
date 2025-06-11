package com.backend.backend_rickandmorty_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import com.backend.backend_rickandmorty_api.models.RickCharacter;

import java.nio.charset.StandardCharsets;
import java.util.*;

// Servicio encargado de consumir la API externa de Rick and Morty.
@Service
public class CharacterService {

    private final String BASE_URL = "https://rickandmortyapi.com/api/character/";

    @Autowired
    private RestTemplate restTemplate;

    public List<RickCharacter> getCharactersByPage(int page) {
        String url = BASE_URL + "?page=" + page;

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

        List<RickCharacter> characters = new ArrayList<>();

        if (results != null) {
            for (Map<String, Object> result : results) {
                RickCharacter character = restTemplate.getForObject(result.get("url").toString(), RickCharacter.class);
                characters.add(character);
            }
        }

        return characters;
    }
    
    // Se obtiene un character por su ID desde la api
    public RickCharacter getCharacterById(int id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, RickCharacter.class);
    }

    // Se realiza una búsqueda de coincidencia por el nombre
    public List<RickCharacter> getCharactersByName(String name) {
        String url = BASE_URL + "/?name=" + UriUtils.encode(name, StandardCharsets.UTF_8);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

        List<RickCharacter> characters = new ArrayList<>();

        if (results != null) {
            for (Map<String, Object> result : results) {
                RickCharacter character = restTemplate.getForObject(result.get("url").toString(), RickCharacter.class);
                characters.add(character);
            }
        }

        return characters;
    }

}
