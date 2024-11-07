package org.example;

import java.util.ArrayList;
import java.util.List;

public class SalitaParaCrearSeres {
    private static List<Animal> animalesInicial = new ArrayList<>();
    private static List<Planta> plantasInicial = new ArrayList<>();

    public static void inicializarAnimales(ISLA isla){

        Aguila.AguilaFactory aguila1 = new Aguila.AguilaFactory();
        Aguila.AguilaFactory aguila2 = new Aguila.AguilaFactory();

        Caballo.CaballoFactory caballo1 = new Caballo.CaballoFactory();
        Caballo.CaballoFactory caballo2 = new Caballo.CaballoFactory();

        Cabra.CabraFactory cabra1 = new Cabra.CabraFactory();
        Cabra.CabraFactory cabra2 = new Cabra.CabraFactory();

        Ciervo.CiervoFactory ciervo1 = new Ciervo.CiervoFactory();
        Ciervo.CiervoFactory ciervo2 = new Ciervo.CiervoFactory();

        Conejo.ConejoFactory conejo1 = new Conejo.ConejoFactory();
        Conejo.ConejoFactory conejo2 = new Conejo.ConejoFactory();

        Lobo.LoboFactory lobo1 = new Lobo.LoboFactory();
        Lobo.LoboFactory lobo2 = new Lobo.LoboFactory();

        Oso.OsoFactory oso1 = new Oso.OsoFactory();
        Oso.OsoFactory oso2 = new Oso.OsoFactory();

        Oveja.OvejaFactory oveja1 = new Oveja.OvejaFactory();
        Oveja.OvejaFactory oveja2 = new Oveja.OvejaFactory();

        Raton.RatonFactory raton1 = new Raton.RatonFactory();
        Raton.RatonFactory raton2 = new Raton.RatonFactory();

        Serpiente.SerpienteFactory serpiente1 = new Serpiente.SerpienteFactory();
        Serpiente.SerpienteFactory serpiente2 = new Serpiente.SerpienteFactory();

        Zorro.ZorroFactory zorro1 = new Zorro.ZorroFactory();
        Zorro.ZorroFactory zorro2 = new Zorro.ZorroFactory();

        for(int i =0; i<=22 ; i++){
            animalesInicial.add(aguila1.crearAnimal(isla));
            animalesInicial.add(aguila2.crearAnimal(isla));
            animalesInicial.add(caballo1.crearAnimal(isla));
            animalesInicial.add(caballo2.crearAnimal(isla));
            animalesInicial.add(cabra1.crearAnimal(isla));
            animalesInicial.add(cabra2.crearAnimal(isla));
            animalesInicial.add(ciervo1.crearAnimal(isla));
            animalesInicial.add(ciervo2.crearAnimal(isla));
            animalesInicial.add(conejo1.crearAnimal(isla));
            animalesInicial.add(conejo2.crearAnimal(isla));
            animalesInicial.add(lobo1.crearAnimal(isla));
            animalesInicial.add(lobo2.crearAnimal(isla));
            animalesInicial.add(oso1.crearAnimal(isla));
            animalesInicial.add(oso2.crearAnimal(isla));
            animalesInicial.add(oveja1.crearAnimal(isla));
            animalesInicial.add(oveja2.crearAnimal(isla));
            animalesInicial.add(raton1.crearAnimal(isla));
            animalesInicial.add(raton2.crearAnimal(isla));
            animalesInicial.add(serpiente1.crearAnimal(isla));
            animalesInicial.add(serpiente2.crearAnimal(isla));
            animalesInicial.add(zorro1.crearAnimal(isla));
            animalesInicial.add(zorro2.crearAnimal(isla));
        }

    }


    public static void inicializarPlantas(ISLA isla){

        Pasto.PastoFactory pasto1 = new Pasto.PastoFactory();
        Pasto.PastoFactory pasto2 = new Pasto.PastoFactory();
        Pasto.PastoFactory pasto3 = new Pasto.PastoFactory();
        Pasto.PastoFactory pasto4 = new Pasto.PastoFactory();
        Pasto.PastoFactory pasto5 = new Pasto.PastoFactory();

        for (int i = 0; i <=10; i++){
            plantasInicial.add(pasto1.crearPlanta(isla));
            plantasInicial.add(pasto2.crearPlanta(isla));
            plantasInicial.add(pasto3.crearPlanta(isla));
            plantasInicial.add(pasto4.crearPlanta(isla));
            plantasInicial.add(pasto5.crearPlanta(isla));

        }
    }
    public static List<Animal> getAnimalesInicial() {
        return animalesInicial;
    }
    public static List<Planta> getPlantasInicial() {
        return plantasInicial;
    }

    // Método para remover un animal de la lista
    public static void removerAnimal(Animal animal) {
        animalesInicial.remove(animal);
        System.out.println("El animal " + animal.getEspecie() + " ha sido removido de la isla.");
    }

    // Método para remover un pasto de la lista (aunque no será necesario en esta propuesta)
    public static void removerPasto(Pasto pasto) {
        plantasInicial.remove(pasto);
        System.out.println("Pasto en posición (" + pasto.getFila() + ", " + pasto.getColumna() + ") ha sido consumido y removido de la isla.");
    }
}



