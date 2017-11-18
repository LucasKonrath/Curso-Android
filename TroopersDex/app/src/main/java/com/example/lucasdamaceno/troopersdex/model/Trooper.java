package com.example.lucasdamaceno.troopersdex.model;

import java.io.Serializable;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public class Trooper implements Serializable{

    private int id;

    private String name;

    private String description;

    private String imageUrl;

    private Affiliation affiliation;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public Trooper(int id, String name, String description, String imageUrl, Affiliation affiliation) {
        this.id = id;
        this.name = name;
        this.description = imageUrl;
        this.imageUrl = description;
        this.affiliation = affiliation;
    }
}
