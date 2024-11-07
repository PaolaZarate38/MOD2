package org.example;

public abstract class Animal implements SerVivo{

    protected String especie;
    protected boolean esHembra;
    private int kilosAlimentoDiario;
    private int peso;
    protected int filaActual;
    protected int columnaActual;
    protected ISLA isla; //Inyeccion de dependencias
    protected IComportamiento comportamiento; //Para strategy
    //protected IMovimiento movimiento; No fue necesario

    // Constructor
    public Animal(String especie, boolean esHembra, int requerimientoDiarioAlimento, int peso, int filaActual, int columnaActual) {
        this.especie = especie;
        this.esHembra = esHembra;
        this.kilosAlimentoDiario = kilosAlimentoDiario;
        this.filaActual = filaActual;
        this.columnaActual = columnaActual;
    }

    //public abstract void comer();

    //public abstract void morir();



    public String getEspecie() {
        return especie;
    }

    public boolean esHembra() {
        return esHembra;
    }

    public int getKilosAlimentoDiario() {
        return kilosAlimentoDiario;
    }

    public int getPeso(){
        return peso;
    }



    public void interactuarCon(Animal otroAnimal) {
        if (comportamiento != null) {
            comportamiento.interactuar(this, otroAnimal);
        }
    }


    //setters para inyeccion de dependencias
    //public void setIsla(ISLA isla) {this.isla = isla;} Se supone que lo necesitaba pero finalmente no fue asi, ya que la variable es protected

    public void setComportamiento(IComportamiento comportamiento) {
        this.comportamiento = comportamiento;
    }

    //public void setMovimiento(IMovimiento movimiento){ this.movimiento = movimiento; } //Finalmente no parece necesario usarlo pero fue parte del proceso



    //Getters y setters para la posicion actual del animal (filaActual y columnaActual)
    public int getFilaActual() {  //Inyeccion de depenencias
        return filaActual;
    }
    public int getColumnaActual() {
        return columnaActual;
    }
    public void setColumnaActual(int columna){
        this.columnaActual = columnaActual;
    }
    public void setFilaActual(int fila){
        this.filaActual = filaActual;
    }
}

