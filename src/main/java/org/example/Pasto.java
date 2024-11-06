package org.example;

import java.util.Random;

public class Pasto extends Planta{
    public Pasto(String tipoDePlanta, boolean haFlorecido, int pesoDisponible, int fila, int columna) {
        super(tipoDePlanta, haFlorecido, pesoDisponible, fila, columna );
    }

    @Override
    public void florecer() {

    }

    @Override
    public void marchitarse() {

    }

    public static class PastoFactory implements PlantaFactory{

        @Override
        public Planta crearPlanta(ISLA isla) {

            Random random = new Random();
            int filaAl = random.nextInt(isla.getFilas());
            int columnaAl = random.nextInt(isla.getColumnas());
            boolean haFlorecido = random.nextBoolean();

            return new Pasto("Pasto", haFlorecido, 100, filaAl, columnaAl);
        }
    }

}
