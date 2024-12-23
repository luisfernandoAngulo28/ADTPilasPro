/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author ferna
 */
public class Pila {

    Nodo tope;
    int dim;

    public Pila() {
        tope = null;
        dim = 0;
    }
    //setters

    public void Push(int elem) {
        Nodo P = new Nodo();
        P.setDato(elem);
        P.setEnlace(tope);
        tope = P;
        dim++;
    }
    //getters

    public int Pop() {
        int x = (int) tope.getDato();
        tope = tope.getEnlace();
        dim--;
        return (x);
    }

    public int Get() {
        return ((int) tope.getDato());
    }
    //metodos auxiliares

    public boolean Vacia() {
        return (tope == null);
    }

    @Override
    public String toString() {
        String S = "";
        Nodo Aux = tope;
        while (Aux != null) {
            S = S + "   " + "[" + Aux.getDato() + "]" + '\n' + "    " + "↓" + '\n';
            Aux = Aux.getEnlace();
        }
        return (S);
    }

    public void eliminarDuplicados() {
        if (Vacia()) {
            return; // Si la pila está vacía, no hay nada que procesar
        }

        Nodo actual = tope;

        while (actual != null) {
            Nodo comparador = actual.getEnlace();
            Nodo anterior = actual;

            while (comparador != null) {
                if (comparador.getDato() == actual.getDato()) {
                    // Eliminar el nodo duplicado
                    anterior.setEnlace(comparador.getEnlace());
                    dim--; // Reducir la dimensión al eliminar un nodo
                } else {
                    anterior = comparador;
                }
                comparador = comparador.getEnlace();
            }
            actual = actual.getEnlace();
        }
    }

  public void eliminarDuplicados2() {
    Nodo actual = tope; // Nodo que recorre la pila
    Nodo anterior; // Nodo anterior al comparador

    while (actual != null) {
        anterior = actual; // Inicializamos el nodo anterior al actual
        Nodo comparador = actual.getEnlace(); // Comienza a comparar desde el siguiente nodo

        while (comparador != null) {
            if (actual.getDato() == comparador.getDato()) {
                // Eliminar el nodo duplicado ajustando el enlace del nodo anterior
                anterior.setEnlace(comparador.getEnlace());
                dim--; // Reducir el tamaño de la pila
            } else {
                anterior = comparador; // Avanzar al siguiente nodo
            }
            comparador = comparador.getEnlace(); // Avanzar en la comparación
        }
        actual = actual.getEnlace(); // Avanzar al siguiente nodo de la pila
    }
}


    public void intercambiarPila(Pila pila1, Pila pila2) {
        Pila aux = new Pila();

        while (!pila1.Vacia()) {
            aux.Push(pila1.Pop());
        }

        while (!pila2.Vacia()) {
            pila1.Push(pila2.Pop());
        }

        while (!aux.Vacia()) {
            pila2.Push(aux.Pop());
        }

        while (!pila1.Vacia()) {
            aux.Push(pila1.Pop());
        }
        pila1.tope = aux.tope;
    }

    public static void main(String[] args) {
        /* Pila pila1 = new Pila();
        Pila pila2 = new Pila();

        // Agregar elementos a pila1
        for (int i = 5; i >= 1; i--) {
            pila1.Push(i);
        }

        // Agregar elementos a pila2
        for (int i = 10; i >= 6; i--) {
            pila2.Push(i);
        }

        System.out.println(pila1.toString());

        System.out.println(pila2.toString());

        pila1.intercambiarPila(pila1, pila2);

        System.out.println(pila1.toString());

        System.out.println(pila2.toString());*/
        //-----------------------------------------------------------------------
        Pila pila = new Pila();

        // Agregar elementos con duplicados
        pila.Push(4);
        pila.Push(5);
        pila.Push(4);
        pila.Push(5);
        pila.Push(3);
        pila.Push(2);

        System.out.println("Pila Original:");
        System.out.println(pila);

        // Eliminar duplicados
        pila.eliminarDuplicados2();

        System.out.println("Pila Sin Duplicados:");
        System.out.println(pila);
    }

}
