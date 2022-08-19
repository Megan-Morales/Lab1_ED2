/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arbolB;

/**
 *
 * @author megan
 */
public class NodoB<E extends Comparable<E>> {
    //Valores
    E valor;  //--> clave
    //Apuntadores
    NodoB<E> anterior, siguiente;
    Pagina hijoIzq;
    Pagina hijoDer;

    public NodoB(E valor) {  //contructor de mi clase
        this.valor = valor;
        this.anterior = this.siguiente=null;
        this.hijoIzq = this.hijoDer= null;
    }

    public NodoB(E valor, Pagina izquierda, Pagina derecha){ //Segundo constructor, aplicar sobre carga de constructores 
        this.valor=valor;
        this.anterior=this.siguiente=null;
        this.hijoIzq=izquierda;
        this.hijoDer=derecha;
    }
    
}
