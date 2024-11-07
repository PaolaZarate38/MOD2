package org.example;

public class AtaquesOyente implements EscuchadorDeEventos{
    @Override
    public void animalCerca(Animal animal1, Animal animal2) {
        if (animal1 instanceof Carnivoro && animal2 instanceof Herbivoro){
            animal1.setComportamiento(new ATACAR());
            animal1.interactuarCon(animal2);
        }
    }
}
