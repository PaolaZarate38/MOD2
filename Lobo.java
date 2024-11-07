package org.example;

import java.util.Random;

public class Lobo extends Carnivoro{
    public Lobo(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }
    public static class LoboFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Lobo("Lobo", esHembra, 8, 50, filaAleatoria, columnaAleatoria);
        }
    }
}
