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
public class Pagina {
    boolean hoja;//identificar si es una hoja
    int contador;//identificar la cantidad de elementos o nodos que tiene la pagina
    NodoB primero; //primero de la pagina

    public Pagina() {
        this.primero = null;
        this.hoja = true;
        this.contador = 0;
    }

    
}
