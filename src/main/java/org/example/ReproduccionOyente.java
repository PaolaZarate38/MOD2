package org.example;

public class ReproduccionOyente implements EscuchadorDeEventos{
    @Override
    public void animalCerca(Animal animal1, Animal animal2) {
        if (animal1.getEspecie().equals(animal2.getEspecie()) && animal1.esHembra() != animal2.esHembra()) {
            animal1.setComportamiento(new REPRODUCIRSE());
            animal2.setComportamiento(new REPRODUCIRSE());
            animal1.interactuarCon(animal2);
            //Como hacer que "produzcan" un nuevo animal??
        }
    }
}
