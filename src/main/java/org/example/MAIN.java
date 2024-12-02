package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MAIN {

    static List<Animal> animales;
    static List<Planta> plantas;

    static int diaActual;
    public static void main(String[] args) {

        ISLA isla = ISLA.elegirTamañoDeLaIsla2();

        // Inicializar animales y plantas
        SalitaParaCrearSeres.inicializarAnimales(isla);
        SalitaParaCrearSeres.inicializarPlantas(isla);

        // Obtener las listas de animales y plantas ya inicializadas
        animales = SalitaParaCrearSeres.getAnimalesInicial();
        plantas = SalitaParaCrearSeres.getPlantasInicial();

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
        ScheduledExecutorService agenda = Executors.newScheduledThreadPool(1);
        agenda.scheduleAtFixedRate(()->{
            for (Animal animal : animales) {
                //System.out.println(animal.getEspecie() + " en posición antes de moverse: " + animal.getFilaActual() + ", " + animal.getColumnaActual());

                MOVERSE movimiento = new MOVERSE(animal);
                movimiento.setIsla(isla); //Inyectar la isla
                movimiento.desplazarse();  //Hacer que el animal se mueva

                //System.out.println(animal.getEspecie() + " se ha movido a la nueva posición: " + animal.getFilaActual() + ", " + animal.getColumnaActual());

                REPRODUCIRSE reproduccion = new REPRODUCIRSE();
                reproduccion.setIsla(isla);
                reproduccion.intentarReproducirse(animal);

            }
            //System.out.println("...Verificando posibles interacciones entre animales ...");
            //isla.accionarEventos(animales); DISPARADOR DE EVENTOS QUE YA NO FUNCIONO



        },0,2, TimeUnit.SECONDS);  //1 dia = 2 segundos



        //ciclo de vida de los herbívoros
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
        }, 1, 2, TimeUnit.SECONDS);  // 1 día = 2 segundos

        //ciclo de vida de los carnivoros

        agenda.scheduleAtFixedRate(()->{
            synchronized (animales) {
                for (Animal animal : new ArrayList<>(animales)) {
                    if (animal instanceof Carnivoro) {
                        Carnivoro carnivoro = (Carnivoro) animal;

                        // Llama al método buscarPresa pasando la lista de animales
                        Animal presa = isla.buscarPresa(carnivoro, animales);

                        if (presa != null) {
                            carnivoro.comerComoCarnivoro(presa);
                            presa.morir();
                        }

                        // Si no encuentra comida en 3 días, muere
                        if (carnivoro.getDiasSinComer() >= 3) {
                            carnivoro.morirComoCarnivoro();
                        }
                    }
                }
            }
        }, 1,2,TimeUnit.SECONDS);

        agenda.scheduleAtFixedRate(() -> {

            generarEstadisticasDiarias("estadisticas_isla");
            diaActual++;
        }, 1, 2, TimeUnit.SECONDS);

        agenda.schedule(() -> {
            agenda.shutdown();
            System.out.println("Simulación terminada.");
        }, 60, TimeUnit.SECONDS);


    }

    private static void generarEstadisticasDiarias(String fileName) {
        // Puedes crear un resumen de las estadísticas del día
        int vivosHerbivoros = (int) animales.stream().filter(a -> a instanceof Herbivoro && a.estaVivo).count();
        int vivosCarnivoros = (int) animales.stream().filter(a -> a instanceof Carnivoro && a.estaVivo).count();
        int muertosHoy = (int) animales.stream().filter(a -> !a.estaVivo).count(); // Los muertos en el día
        int interaccionesHoy = 0; // Lleva un contador de interacciones diarias (puedes añadirlo si tienes ese dato)

        // Aquí formateamos el texto que se guardará
        String estadisticas = String.format(
                "Día %d: Herbívoros vivos: %d, Carnívoros vivos: %d, Animales muertos hoy: %d, Interacciones hoy: %d",
                diaActual, vivosHerbivoros, vivosCarnivoros, muertosHoy, interaccionesHoy
        );

        // Llamar al método FileManager para guardar el archivo
        ManejadorDeArchivos.archivar(fileName, estadisticas);
    }

}