package com.example.lucasdamaceno.troopersdex.model;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public enum Affiliation {

    GALACTIC_REPUBLIC(0),
    GALACTIC_EMPIRE(1),
    FIRST_ORDER(2);

    Affiliation(int value){
        this.value = value;
    }

    private int value;

    public int getValue(){
        return value;
    }
}
