package org.example;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        ISLA isla = ISLA.elegirTamañoDeLaIsla2(); //El usuario crea la isla

        SalitaParaCrearSeres.inicializarAnimales(isla); //Se inicializan os animales en dicha isla

        List<Animal> animales = SalitaParaCrearSeres.getAnimalesInicial();


        Animal animalSeleccionado = animales.get(0); //Cambia el índice para probar diferentes animales

        //Colocar el animal
        isla.colocarAnimalAleatoriamente(animalSeleccionado);
        System.out.println(animalSeleccionado.getEspecie() + " colocado en la posición inicial: " +
                animalSeleccionado.getFilaActual() + ", " + animalSeleccionado.getColumnaActual());

        //Mover el animal seleccionado
        MOVERSE movimiento = new MOVERSE(animalSeleccionado);
        movimiento.setIsla(isla); //Inyectar la isla
        movimiento.desplazarse();

        System.out.println("...Verificando posibles interacciones entre animales ...");
        isla.accionarEventos(animales);
    }
}
