package org.example;

import java.util.Random;

public class Aguila extends Carnivoro{


    public Aguila(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class AguilaFactory implements AnimalFactory {

        @Override
        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean(); // Elige aleatoriamente true o false
            return new Aguila("Aguila", esHembra, 1,6,filaAleatoria, columnaAleatoria);
        }
    }
}
