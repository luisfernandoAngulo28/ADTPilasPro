/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author fernandoo EL 23
 */
public class Pila {

    int P[];
    int cima;

    //constructor
    public Pila(int cant) {
        cima = -1;
        P = new int[cant];

    }

    /*3|____| 
      2|____|
      1|____|
      0|____|
     <- cima
     */
    // pila vacia
    public boolean vacia() {
        return (cima == -1);
    }

    /* 3|__5__|<- cima 
      2|__4__|
      1|__3__|
      0|__2__|
       solo aqui estara llena
    p.length - 1
     */
    public boolean llena() {
        return (cima == P.length - 1);
    }

    /*3|__5__|<- cima 
      2|__4__|
      1|__3__|
      0|__2__|
   
     */
    public void push(int ele) {//introducimos el elemento
        if (llena()) {//primero preguntamos si esta lleno
            System.out.println("pila llena");//mensaje
        } else {//caso contrario
            cima++;//aumenta el cima una posicion

            P[cima] = ele;   //introduce el dato en la posicion Tope(cima)
        }
    }

    /*
      3|__5__|<- cima 
      2|__4__|
      1|__3__|
      0|__2__|
   si la pila esta vacia no nada que devolver
    ⌂ asumimos que tiene un elemento
     */
    public int pop() {
        int x = P[cima];
        cima--;//vajamos abajo   
        return x;
    }

    public int Pop() {
        int x = -1;
        if (!vacia()) {
            x = P[cima];
            cima--;
        } else {
            System.out.println("PILA VACIA");
        }
        return x;
    }

    /*3|__0__|<- cima 
      2|__3__|
      1|__2__|
      0|__1__|
   
     */
    //Saca el ultimo elemento pero no lo elimina
    public int getcima() {
        return P[cima];
    }

    /*invertir()
    
Entrada        Salida
|___5___|  |___1___|
|___4___|  |___2___|
|___3___|  |___3___|
|___2___|  |___4___|
|___1___|  |___5___|
     P       aux
     */
    public void invertir() {
        Pila aux = new Pila(cima + 1);///creamos una pila aux y en este metodo cima
        int i = 0;
        int a, j;
        while (i < cima) {//
            a = pop();// sacamos el dato
            j = cima + 1 - i;//
            while (j > 0) {
                aux.push(pop()); //lo que saque le introduzco a la pila aux
                j--;
            }
            push(a);
            while (!aux.vacia()) {
                push(aux.pop());
            }
            i++;
        }
    }

    /*invertir()
    
Entrada        Salida
|___5___|  |___1___|
|___4___|  |___2___|
|___3___|  |___3___|
|___2___|  |___4___|
|___1___|  |___5___|
     P       aux
     */
    public void invertirR() {
        Pila p1 = new Pila(cima + 1);
        invertir_rec(p1);
    }

    private void invertir_rec(Pila p1) {
        if (!vacia()) {
            p1.push(pop());
            invertir_rec(p1);
            cima = p1.cima;
            P = p1.P;
        }
    }

    //  implementar un metodo que invierta la pila de dos en dos
    /*
Entrada
|___3___|
|___2___|
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|
     */
    
     /*
    Dada una pila P realizar un metodo para eliminar 
    los elementos repetidos  de esta es decir 

	5|__5__|<- tope 
      	4|__4__|
 	3|__5__| 
      	2|__4__|
     	1|__3__|
      	0|__2__|
    salida

 	3|__5__|<- tope 
      	2|__4__|
     	1|__3__|
      	0|__2__|
     */
    public void eliminarRepetido() {
        Pila pilaAux = new Pila(cima + 1);
        int comparador = 0;
        while (cima != comparador && !vacia()) {
            int actual = pop();
            while (cima >= comparador) {
                int aux = pop();
                if (actual != aux) {
                    pilaAux.push(aux);
                }
            }
            push(actual);
            while (!pilaAux.vacia()) {
                push(pilaAux.pop());
            }
            comparador++;
        }
    }

    

    /*
 Entrada
|___3___|
|___2___|
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida
|___1___|
|___5___|
|___4___|
     */
    public void eliminarRepIn() {
        Pila aux = new Pila(cima + 1);
        int x, c;
        int j = 0;
        while (j < cima) {
            c = 0;
            while (!vacia()) {
                aux.push(pop());
            }
            x = aux.pop();
            while (!aux.vacia()) {
                if (x != aux.getcima()) {
                    push(aux.pop());
                } else {
                    c++;
                    aux.pop();
                }
            }
            if (c == 0) {
                push(x);
            }
            j++;
        }

    }
    public void eliminarRepeIn() {
    Pila aux = new Pila(cima + 1); // Pila auxiliar para procesar elementos
    int elemento, contador;
    int iteraciones = 0;

    while (iteraciones < cima) {
        contador = 0;

        // Transferimos todos los elementos de la pila original a la auxiliar
        while (!vacia()) {
            aux.push(pop());
        }

        // Obtenemos el elemento actual para procesar
        elemento = aux.pop();

        // Revisamos la pila auxiliar para eliminar duplicados del elemento actual
        while (!aux.vacia()) {
            if (elemento != aux.getcima()) {
                push(aux.pop()); // Regresamos los elementos no duplicados
            } else {
                contador++;
                aux.pop(); // Descartamos los duplicados
            }
        }

        // Si el elemento no tuvo duplicados, lo mantenemos en la pila original
        if (contador == 0) {
            push(elemento);
        }

        iteraciones++;
    }
}

    /*Entrada
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida
1
     */
    public int eleMen() {  //muestra el menor
        Pila aux = new Pila(P.length);
        aux.P = P;
        aux.cima = cima;
        int men = aux.pop();
        while (aux.cima >= 0) {
            int cmp = aux.pop();
            if (men > cmp) {
                men = cmp;
            }
        }
        return men;
    }

    //---------------------------------
    /*Entrada
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida
|___4___|
|___2___|
     */
    public void eliminar_impares() {
        if (cima == -1) {
            return;
        } else {
            int x = pop();
            eliminar_impares();
            if (x % 2 == 0) {
                push(x);
            }
        }
    }

    public void mov_extremos(Pila a, Pila b) {
        int c = 0;
        int i = 0;
        if ((cima + 1) % 2 == 0) {
            c = (cima + 1) / 2;  //3
            System.out.println(c);
        } else {
            c = ((cima + 1) / 2) + 1; //3
            System.out.println(c);
        }
        int x = a.pop();
        int y = b.pop();
        while (!b.vacia()) {
            a.push(b.pop());
        }
        b.push(x);
        int x2 = a.pop();
        while (!a.vacia()) {
            b.push(a.pop());
        }
        a.push(y);
        int y2 = b.pop();
        while (i < c) {
            a.push(b.pop());
            i++;
        }
        a.push(x2);
        b.push(y2);
    }

    //------------------------ E L I M I N A R -------------------------------

    /*Entrada
|___3___|
|___2___|
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida

|___5___|
|___4___|
|___3___|
|___2___|
|___1___|*/ //Recursivo Caso k-1
    public void eliminar_duplicados() {
        if (cima == -1) {
            return;
        } else {
            int aux = contar_duplicados(getcima());
            int x = pop();
            eliminar_duplicados();
            if (aux == 1) {
                push(x);
            }
        }
    }

    public int contar_duplicados(int ele) {
        int c;
        if (cima == 0) {
            int x = pop();
            push(x);
            c = x == ele ? 1 : 0;
        } else {
            int x = pop();
            c = contar_duplicados(ele);
            if (x == ele) {
                c++;
            }
            push(x);
        }
        return c;
    }


    /*
Invertir extremos
Entrada
|___5___|
|___4___|
|___3___|
|___2___|
|___1___|

Salida
|___1___|
|___4___|
|___3___|
|___2___|
|___5___|
     */
    public void priult() {
        int x;
        int y = 0;
        int z;
        int i = cima;
        x = pop();
        while (i > 1) {
            y = (y * 10) + (pop());
            i--;
        }
        z = pop();
        push(x);
        while (y != 0) {
            x = y % 10;
            push(x);
            y = y / 10;
        }
        push(z);
    }

    public void Volcar2() {
        if (vacia()) {
            //nada
        } else {
            int x = Pop();
            int y = 0;
            if (!vacia()) {
                y = Pop();
            }
            Volcar2();
            push(x);
            if (y > 0) {
                push(y);
            }
        }

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = cima; i >= 0; i--) {
            s = s + "|___" + Integer.toString(P[i]) + "___|";
            s += "\n";
        }
        return s;
    }
    
    public void InvertirExtremos(){
        Pila aux=new Pila(cima+1);
        int x=pop();
        while (!vacia()) {            
            int y=pop();
            aux.push(y);
        }
        push(x);
        int z=aux.pop();
        while (!aux.vacia()) {            
            push(aux.pop());
        }
        push(z);
    }

/* |___5___|   |___10___|  <- inicio
   |___4___|   |___9___|
   |___3___|   |___8___|
   |___2___|   |___7___|
   |___1___|   |___6___|
       a           b         */
    public void IntercambiarExtremos23(Pila a, Pila b) {
        int c = 0;
        if ((cima + 1) % 2 == 0) {
            c = (cima + 1) / 2; //3

        } else {
            c = ((cima + 1)) / 2 + 1;
        }
        /*                          <- inicio
   |___4___|   |___9___|
   |___3___|   |___8___|
   |___2___|   |___7___|
   |___1___|   |___6___|
       a           b         */
        int x = a.Pop(); //5
        int y = b.Pop();//10
        while (!b.vacia()) {
            a.push(b.Pop()); //paso de una pila a otra
        }
        /*
|___6___|
|___7___|
|___8___|       
|___9___|
|___4___|
|___3___|
|___2___|
|___1___|
    a   */
        b.push(x);//5
        /*
|______|
|______|
|______|
|______|
|___5___|
    b   
         */
 /*
|___7___|
|___8___|       
|___9___|
|___4___|
|___3___|
|___2___|
|___1___|
    a   */
        int x2 = a.Pop();//6
        while (!a.vacia()) {
            b.push(a.Pop()); //de la pila a pasar a b           
        }
        /*
|___1___|
|___2___|
|___3___|       
|___4___|
|___9___|
|___8___|
|___7___|
|___5___|  |______|  
    b          a    */
        a.push(y);  //10
        /*
|___1___|
|___2___|            
|___3___|       
|___4___|
|___9___|
|___8___|
|___7___|
|___5___|  |___10___|  
    b          a    */
        int y2 = b.Pop();//1
        /*  y2=1
|___2___|            
|___3___|       
|___4___|
|___9___|
|___8___|
|___7___|
|___5___|  |___10___|  
    b          a    */
        int i = 0;  //C=3;
        while (i < c) {
            a.push(b.pop());
            i++;
        }
        /* 
|___9___|  |___4____|
|___8___|  |___3____| 
|___7___|  |___2____| 
|___5___|  |___10___|  
    b          a    */

        a.push(x2);//6
        b.push(y2);//1
        /* 
|___1___|  |___6____|  
|___9___|  |___4____|
|___8___|  |___3____| 
|___7___|  |___2____| 
|___5___|  |___10___|  
    b          a    */

    }

    public void interExtremos(Pila a, Pila b) {
        int c = 0;
        if ((cima + 1) % 2 == 0) {      // si es par o impar

            c = ((cima + 1) / 2);     // vacia pero se queda el ultimo ele

        } else {
            c = ((cima + 1)) / 2 + 1;
        }
        int x = a.pop();  // se guarda el primero 5
        int y = b.pop();  // se guarda el 10

        while (!b.vacia()) {
            a.push(b.pop()); // paso de una pila a otra
        }
        b.push(x); // entra 5
        int x2 = a.pop();  // se guarda el 6
        while (!a.vacia()) {
            b.push(a.pop());  //de la pila a pasa a la pila b

        }
        a.push(y);   //  introduzo el 10 en la pila a
        int y2 = b.pop(); // se guarda el valor 1
        int i = 0;         // c=3
        while (i < c) {      // meteras los 3 primeros
            a.push(b.pop());
            i++;
        }
        a.push(x2);//6    // se colo
        b.push(y2);//1

    }

    public void invertirunosiunono() {
        int b = cima + 1;
        int a = 0;

        //System.out.println("cima ="+b);
        if ((cima + 1) % 2 == 0) {
            int aux = pop();
            Pila pilaaux = new Pila(cima + 1);
            pilaaux.push(aux);
            //push(aux);
            System.out.println(pilaaux.toString());
            System.out.println("cima" + cima);
        } else {
            a = a * 10 + pop();
            System.out.println("aa" + a);

        }
    }

    public int Mayor() {
        //Caso Base si la Pila no esta vacia
        if (cima == 0) {
            return P[cima];
        } else {  //Caso General n-1
            int x = Pop();
            int May = Mayor();//vos me sacas el mayor 
            push(x);
            if (x > May) {//Comparamos
                May = x;
            }
            return May;
        }
    }

    public static void main(String[] args) {
        /* Pila p = new Pila(10);
        for (int i = 6; i > 0; i--) {
            p.push(i);
        }
        System.out.println(p);
        p.priult();
        System.out.println(p);*/
        Pila p = new Pila(10);
        p.push(3);
        p.push(1);

        for (int i = 4; i > 0; i--) {
            p.push(i);
        }

        System.out.println("Pila");
        System.out.println(p);
        p.eliminar_duplicados();
        System.out.println("Salida");
        System.out.println(p);

    }
}
