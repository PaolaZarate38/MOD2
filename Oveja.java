package org.example;

import java.util.Random;

public class Oveja extends Herbivoro{
    public Oveja(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class OvejaFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Oveja("Oveja", esHembra, 15, 70, filaAleatoria, columnaAleatoria);
        }
    }
}
