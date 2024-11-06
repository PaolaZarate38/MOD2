package org.example;

public class REPRODUCIRSE implements IComportamiento{

    @Override
    public void interactuar(Animal animal, Animal otroAnimal) {
        if(animal.getEspecie().equals(otroAnimal.getEspecie()) && animal.esHembra == true && otroAnimal.esHembra == false){
            System.out.println("Reproduccion exitosa: " + animal.getEspecie() + " y " + otroAnimal.getEspecie() + " Se estan apareando");
        } else {
            System.out.println("Los animales no pueden aparearse");
        }
    }
}
