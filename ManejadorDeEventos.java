package org.example;

import java.util.ArrayList;
import java.util.List;

public class ManejadorDeEventos {

    private List<EscuchadorDeEventos> oyentes = new ArrayList<>();

    public void añadirNuevoOyente(EscuchadorDeEventos oyente){
        oyentes.add(oyente);
    }
    public void notificarOyentes(Animal animal1, Animal animal2){
        for(EscuchadorDeEventos oyente: oyentes){
            oyente.animalCerca(animal1,animal2);
        }
    }
}
