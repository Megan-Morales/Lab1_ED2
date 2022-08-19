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
public class ArbolB<E extends Comparable<E>> { 

  final int orden_arbol = 5;  //Esto se puede modificar según el grado del árbol que quiero que sea, en este caso grado 5, máximo 5 conexiones, 4 mínimo.
  Pagina raiz;

    public ArbolB() {   //constructor de mi clase 
        this.raiz = null;
    }

   
    
  
}
