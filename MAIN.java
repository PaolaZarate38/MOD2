package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MAIN {
    public static void main(String[] args) {

        ISLA isla = ISLA.elegirTamañoDeLaIsla2();

        // Inicializar animales y plantas
        SalitaParaCrearSeres.inicializarAnimales(isla);
        SalitaParaCrearSeres.inicializarPlantas(isla);

        // Obtener las listas de animales y plantas ya inicializadas
        List<Animal> animales = SalitaParaCrearSeres.getAnimalesInicial();
        List<Planta> plantas = SalitaParaCrearSeres.getPlantasInicial();

        //Comienza la colocacion de los animales y las plantas dentro de la isla
        for (Animal animal : animales) {
            isla.colocarAnimalAleatoriamente(animal);
        }
        System.out.println("Todos los animales han sido colocados aleatoriamente en la isla");

        for(Planta planta : plantas){
            isla.colocarPlantaAleatoriamente(planta);
        }
        System.out.println("Todas las plantas han sido colocadas aleatoriamente en la isla");

        //Ciclos diarios
        ScheduledExecutorService agenda = Executors.newScheduledThreadPool(2);
        agenda.scheduleAtFixedRate(()->{
            for (Animal animal : animales) {
                //System.out.println(animal.getEspecie() + " en posición antes de moverse: " + animal.getFilaActual() + ", " + animal.getColumnaActual());

                MOVERSE movimiento = new MOVERSE(animal);
                movimiento.setIsla(isla); //Inyectar la isla
                movimiento.desplazarse();  //Hacer que el animal se mueva

                System.out.println(animal.getEspecie() + " se ha movido a la nueva posición: " + animal.getFilaActual() + ", " + animal.getColumnaActual());

            }
            System.out.println("...Verificando posibles interacciones entre animales ...");
            isla.accionarEventos(animales);

            //Verificar supervivencia
            //for (Animal animal : animales) {
                //animal.morir();
            //}

        },0,2, TimeUnit.SECONDS);  //1 dia = 2 segundos

        //ciclo de vida y acciones de los herbívoros
        agenda.scheduleAtFixedRate(() -> {
            for (Animal animal : new ArrayList<>(animales)) {
                if (animal instanceof Herbivoro) {
                    Herbivoro herbivoro = (Herbivoro) animal;
                    herbivoro.comerComoHerbivoro();

                    if (herbivoro.getDiasSinComer() >= 3) {  // Si han pasado 3 días sin comer
                        herbivoro.morirComoHerbivoro();
                    }
                }
            }
        }, 0, 2, TimeUnit.SECONDS);  // 1 día = 2 segundos

        agenda.schedule(() -> {
            agenda.shutdown();
            System.out.println("Simulación terminada.");
        }, 60, TimeUnit.SECONDS);


    }

}