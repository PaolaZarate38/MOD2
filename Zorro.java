package org.example;

import java.util.Random;

public class Zorro extends Carnivoro{
    public Zorro(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class ZorroFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean(); // Elige aleatoriamente true o false
            return new Zorro("Zorro", esHembra, 2, 8, filaAleatoria, columnaAleatoria);
        }
    }
}
