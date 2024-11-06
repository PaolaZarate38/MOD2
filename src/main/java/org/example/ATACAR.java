package org.example;


public class ATACAR implements IComportamiento{

    @Override
    public void interactuar(Animal atacante, Animal otroAnimal) {
        if(atacante instanceof Carnivoro && !atacante.esHembra && otroAnimal instanceof Carnivoro && !otroAnimal.esHembra){
            System.out.println("Se desato una pelea por territorio entre dos machos de la misma especie: "
                    + atacante.getEspecie() + " y " + otroAnimal.getEspecie() );
        } else if (atacante instanceof Carnivoro && otroAnimal instanceof Herbivoro) {
            System.out.println(atacante.getEspecie() + " está atacando a " + otroAnimal.getEspecie());

            ((Carnivoro) atacante).comerComoCarnivoro(otroAnimal);
            ((Herbivoro) otroAnimal).morirComoHerbivoro();
        }
    }
}
