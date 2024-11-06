package org.example;

import java.util.Random;

public class Serpiente extends Carnivoro{
    public Serpiente(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class SerpienteFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Serpiente("Serpiente", esHembra, 3, 15, filaAleatoria, columnaAleatoria);
        }
    }
}
