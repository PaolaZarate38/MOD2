package org.example;

import java.util.List;


public class Herbivoro extends Animal{
    private int diasSinComer = 0;
    public Herbivoro(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento,peso , filaActual, columnaActual);
    }

    public void comerComoHerbivoro(){
        boolean haComido = false;
        for (Planta planta : SalitaParaCrearSeres.getPlantasInicial()) {
            if (planta instanceof Pasto && estanCerca(this, (Pasto) planta)) {
                System.out.println(getEspecie() + " ha comido pasto en posición (" + planta.getFila() + ", " + planta.getColumna() + ")");
                resetearDiasSinComer();
                haComido = true;
                break;
            }
        }
        if(!haComido){
            incrementarDiasSinComer();
        }
    }


    public void morirComoHerbivoro(){

        //si fue atacado y comido
        System.out.println(this.getEspecie() + " Ha muerto tras ser tacado y comido por un carnivoro");

        //si es murio por falta de alimento
            System.out.println(getEspecie() + " ha muerto por falta de alimento.");
            SalitaParaCrearSeres.removerAnimal(this);

    }

    private boolean estanCerca(Animal animal, Pasto pasto){
        int difDeFilasP = Math.abs(animal.getFilaActual() - pasto.getFila());
        int difDeColumnasP = Math.abs(animal.getColumnaActual() - pasto.getColumna());
        if (difDeFilasP <= 1 && difDeFilasP <= 1){
            return true;
        }else{
            return false;
        }
    }

    public void incrementarDiasSinComer() {
        diasSinComer++;
    }

    public int getDiasSinComer() {
        return diasSinComer;
    }

    public void resetearDiasSinComer() {
        diasSinComer = 0;
    }

}
