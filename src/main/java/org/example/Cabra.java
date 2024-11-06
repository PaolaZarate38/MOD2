package org.example;

import java.util.Random;

public class Cabra extends Herbivoro{
    public Cabra(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento,peso, filaActual, columnaActual);
    }

    public static class CabraFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Cabra("Cabra", esHembra, 10, 60, filaAleatoria, columnaAleatoria);
        }
    }
}
