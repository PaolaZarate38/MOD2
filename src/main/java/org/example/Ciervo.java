package org.example;

import java.util.Random;

public class Ciervo extends Herbivoro{
    public Ciervo(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class CiervoFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaActual = random.nextInt(isla.getFilas());
            int columnaActual = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Ciervo("Ciervo", esHembra, 20, 250, filaActual, columnaActual);
        }
    }
}
