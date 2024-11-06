package org.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ISLA {
    private int filas;
    private int columnas;
    private SerVivo[][] isla;
    private ManejadorDeEventos manejador = new ManejadorDeEventos();

    public ISLA(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.isla = new SerVivo[filas][columnas]; // Inicializa la matriz

        manejador.añadirNuevoOyente(new AtaquesOyente());
        manejador.añadirNuevoOyente(new ReproduccionOyente());

    }


    // Modificación: ahora el método devuelve la instancia de la isla creada
    public static ISLA elegirTamañoDeLaIsla2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Puedes elegir el tamaño de tu isla, con el numero de filas y columnas..." +
                "NO PUEDEN SER VALORES MENORES A 0");
        System.out.print("Introduce el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ahora introduce el número de columnas: ");
        int columnas = scanner.nextInt();

        ISLA isla = new ISLA(filas, columnas);
        System.out.println("Isla creada con tamaño " + filas + " X " + columnas);
        return isla;
    }


    // Método para colocar manualmente animales en posiciones aleatorias
    public void colocarAnimalAleatoriamente(Animal animal) {
        Random random = new Random();
        int fila, columna;

        do{
            fila = random.nextInt(filas);
            columna = random.nextInt(columnas);
        }while (isla [fila][columna] != null);

        isla[fila][columna] = animal;
        animal.setFilaActual(fila); // Actualiza la fila actual del animal
        animal.setColumnaActual(columna); // Actualiza la columna actual del animal


        //System.out.println(animal.getEspecie() + " en la posicion: " + fila + "," + columna);

    }

    public void colocarPlantaAleatoriamente(Planta planta) {
        Random random = new Random();
        int fila, columna;
        do{
            fila = random.nextInt(filas);
            columna = random.nextInt(columnas);

        }while (isla[fila][columna] != null);

        isla [fila][columna] = planta;
        //System.out.println(planta.getTipoDePlanta() + " ha crecido en la posicion: " + fila + "," + columna );
    }


    // Método para mover un animal dentro de la matriz
    public void moverAnimal(int filaActual, int columnaActual, int nuevaFila, int nuevaColumna) {
        SerVivo animal = isla[filaActual][columnaActual];
        isla[filaActual][columnaActual] = null; // Elimina el animal de su posición actual
        isla[nuevaFila][nuevaColumna] = animal; // Coloca el animal en la nueva posición
    }



    //Metodo para saber que animal es el que esta en esa posicion
    public Animal obtenerAnimal(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (Animal) isla[fila][columna];
        }
        return null;
    }

    //getters
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }

    public SerVivo[][] getIsla(){return isla;}


    //Metodo que determina si dos animales se encuentran cerca (en alguna posion adyacente a la suya)
    private boolean estanCerca(Animal animal1, Animal animal2) {
        int difDeFilas = Math.abs(animal1.getFilaActual() - animal2.getFilaActual());
        int difDeColumnas = Math.abs(animal1.getColumnaActual() - animal2.getColumnaActual());
        if (difDeFilas <= 1 && difDeColumnas<= 1){
            return true;
        }else{
            return false;
        }
    }


    //Metodo que pone en marcha los eventos cuando dos animales esten cerca esten cerca
    public void accionarEventos(List<Animal> animales) {
        for (int i = 0; i < animales.size(); i++) {
            Animal animal1 = animales.get(i);
            for (int j = i + 1; j < animales.size(); j++) {
                Animal animal2 = animales.get(j);
                if (estanCerca(animal1, animal2)) {
                    manejador.notificarOyentes(animal1, animal2);
                }
            }
        }
    }

    //public void removerAnimal(Animal animal) {
        //animales.remove(animal);
        //System.out.println("El animal " + animal.getEspecie() + " ha sido removido de la isla.");
    //}

}

