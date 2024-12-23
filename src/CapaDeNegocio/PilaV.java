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
public class PilaV {

    int P[];
    int cima;

    //constructor
    public PilaV(int cant) {
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

    public void elimina() {
        if (this.cima > -1) {
            cima--;
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
        PilaV pilaAux = new PilaV(cima + 1);
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
Dada una pila P realizar un metodo para eliminar 
los elementos repetidos y asi mismo de esta es decir 

	5|__1__|<- tope 
      	4|__2__|
 	3|__3__| 
      	2|__4__|
     	1|__1__|
      	0|__3__|
salida

     	1|__2__|<- tope 
      	0|__4__|    
    
     */
    public void eliminarRepeIn() {
        PilaV aux = new PilaV(cima + 1);
        int iterador = 0;
        int elemento;
        int contador;//
        while (iterador <= cima) {
            contador = 0;
            while (!vacia()) {
                aux.push(pop());
            }
            elemento = aux.pop();
            while (!aux.vacia()) {
                if (elemento != aux.getcima()) {
                    push(aux.pop());
                } else {
                    contador++;
                    aux.pop();//elimina();
                }
            }
            if (contador == 0) {
                push(elemento);
            }
            iterador++;
        }
    }

   /* public void delRepPilaOrden() {
        if (vacia() ) {
            
        }else{
            int salva = pop();
            delRepPilaOrden();
            int x = getcima();
            if (x != salva) {
                push(salva);
            }
        }
    }*/

 public void IntercambiarExtremos(){
     PilaV aux=new PilaV(cima+1);
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
//---------------------------------------------------------------------------------------------------------

/* |___5___|   |___10___|  <- inicio
   |___4___|   |___9___|
   |___3___|   |___8___|
   |___2___|   |___7___|
   |___1___|   |___6___|
       a           b         */
    public void IntercambiarExtremos23(PilaV a, PilaV b) {
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
    
    
    
    
  public void IntercambiarMitad(PilaV P,PilaV Q){
    PilaV aux=new PilaV(cima+1);
    int cant1=0,cant2=0,cant3=0;
      while (P.cima>cant1) {          
          aux.push(P.pop());
          cant1++;
      }
      while (Q.cima>cant2) {          
          aux.push(Q.pop());
          cant2++;
      }
      while (aux.cima>cant3) {          
          P.push(aux.pop());
          cant3++;
      }
      while (!aux.vacia()) {          
          Q.push(aux.pop());
      }
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //-------------------------------------------------------
    public static void main(String[] args) {
       /* PilaV p = new PilaV(10);
        p.push(3);
        p.push(1);
        p.push(2);

        for (int i = 4; i > 0; i--) {
            p.push(i);
        }

        System.out.println("Pila");
        System.out.println(p);
       // p.eliminarRepeIn();
       p.IntercambiarExtremos();
        System.out.println("Salida");
        System.out.println(p);*/
       
       
       PilaV a=new PilaV(10);
       PilaV b=new PilaV(10);
        for (int elemento = 1; elemento <= 5; elemento++) {
            a.push(elemento);
        }
        for (int elemento = 6; elemento <= 10; elemento++) {
            b.push(elemento);
        }
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        
        a.IntercambiarExtremos23(a, b);
        
        System.out.println(a.toString());
        System.out.println(b.toString());

    }
}
