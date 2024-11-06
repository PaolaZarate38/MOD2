package org.example;

import java.util.Random;

public class Caballo extends Herbivoro{
    public Caballo(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class CaballoFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Caballo("Caballo", esHembra, 60,400, filaAleatoria, columnaAleatoria);
        }
    }
}
