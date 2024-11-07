package org.example;

public class Carnivoro extends Animal{

    private int diasSinComer = 0;
    public Carnivoro(String especie, boolean esHembra, int requerimientoDiarioAlimento,int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento,peso, filaActual, columnaActual);
    }
    public void comerComoCarnivoro(Animal otroAnimal) {
        System.out.println(this.getEspecie() + " Se comio al " + otroAnimal.getEspecie());
    }

    public void morirComoCarnivoro(){
        System.out.println(this.getEspecie() + " No ha comido en mucho tiempo y murio de hambre");
    }

}
