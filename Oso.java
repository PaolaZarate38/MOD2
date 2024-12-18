package org.example;

import java.util.Random;

public class Oso extends Carnivoro{
    public Oso(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        super(especie, esHembra, requerimientoDiarioAlimento, peso, filaActual, columnaActual);
    }

    public static class OsoFactory implements AnimalFactory {

        public Animal crearAnimal(ISLA isla) {
            Random random = new Random();
            int filaAleatoria = random.nextInt(isla.getFilas());
            int columnaAleatoria = random.nextInt(isla.getColumnas());
            boolean esHembra = random.nextBoolean();
            return new Oso("Oso", esHembra, 80, 500, filaAleatoria, columnaAleatoria);
        }
    }
}
