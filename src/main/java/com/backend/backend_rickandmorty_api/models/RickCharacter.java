package com.backend.backend_rickandmorty_api.models;

import java.util.List;

import lombok.Data;

// Mapeo de la entidad "character"
/*
 * Se cambió el nombre por RickCharacter porque la clase Character ya existe.
 */
@Data
public class RickCharacter {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
