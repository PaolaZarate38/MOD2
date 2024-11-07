package org.example;

public abstract class Planta implements SerVivo{
    private String tipoDePlanta;
    private boolean haFlorecido;

    int kilosDisponibles;

    int fila;

    int columna;

    protected ISLA isla; //inyeccion

    public Planta(String tipoDePlanta, boolean haFlorecido, int kilosDisponibles, int fila, int columna){
        this.tipoDePlanta = tipoDePlanta;
        this.haFlorecido = haFlorecido;
        this.kilosDisponibles = kilosDisponibles;
        this.fila = fila;
        this.columna = columna;
    }

    public abstract void florecer();
    public abstract void marchitarse();

    public String getTipoDePlanta() {
        return tipoDePlanta;
    }
    public boolean getHaFlorecido(){
        return haFlorecido;
    }

    public int getFila(){ return fila; }
    public int getColumna(){ return columna; }

    public void setIsla(ISLA isla) {
        this.isla = isla;
    }
}
