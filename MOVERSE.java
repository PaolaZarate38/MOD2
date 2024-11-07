package org.example;

public class MOVERSE implements IMovimiento{

    private Animal animal;
    private ISLA isla; //Inyeccion de ISLA
    public MOVERSE(Animal animal) {
        this.animal = animal;
    }

    //Setter para inyectar la isla
    public void setIsla(ISLA isla) {
        this.isla = isla;
    }

    @Override
    public void desplazarse() { //Este metodo calcula el movimiento que puede realizar el animal

        int filaActual = animal.getFilaActual();
        int columnaActual = animal.getColumnaActual();

        //Nueva posicion aleatoria (arriba, abajo, izquierda, derecha)
        int nuevaFila = filaActual + (int)(Math.random() * 3) - 1; // Mueve -1, 0 o 1
        int nuevaColumna = columnaActual + (int)(Math.random() * 3) - 1; // Mueve -1, 0 o 1

        //Verificacion de que la nueva posicion se encuentre dentro de los limites de la matriz
        if (nuevaFila >= 0 && nuevaFila < isla.getFilas() && nuevaColumna >= 0 && nuevaColumna < isla.getColumnas()) {
            //Se llama al metodo que puede realizar el movimiento desntro de la matriz (actualiza la posicion )
            isla.moverAnimal(filaActual, columnaActual, nuevaFila, nuevaColumna);
            System.out.println(animal.getEspecie() + " se ha movido a la posición: " + nuevaFila + ", " + nuevaColumna);
        }
    }
}
