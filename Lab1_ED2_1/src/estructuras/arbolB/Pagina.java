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

    
public void insertarEnPagina(NodoB nuevo) {
        if (primero == null) {
            //primero en la lista
            primero = nuevo;
            contador++;
        } else {
            //recorrer e insertarEnPagina
            NodoB aux = primero;
            while (aux != null) {
                if (aux.valor.compareTo(nuevo.valor) == 0 ) {//------------->ya existe en el arbol, validacion que no me permite repetidos
                    if(aux.cabeza == false ){
                        aux.cabeza = true;
                    }
                    aux.listaRepetidos.insertElement_AtEnding(nuevo.valor);
                    
                    break;
                } else {
                    if (aux.valor.compareTo(nuevo.valor) > 0) {
                        if (aux == primero) {//------------->insertarEnPagina al inicio
                            aux.anterior = nuevo;
                            nuevo.siguiente = aux;
                            //ramas del nodo
                            aux.hijoIzq = nuevo.hijoDer;
                            nuevo.hijoDer = null;

                            primero = nuevo;
                            contador++;
                            break;
                        } else {//------------->insertarEnPagina en medio;
                            nuevo.siguiente = aux;
                            //ramas del nodo
                            aux.hijoIzq = nuevo.hijoDer;
                            nuevo.hijoDer = null;

                            nuevo.anterior = aux.anterior;
                            aux.anterior.siguiente = nuevo;
                            aux.anterior = nuevo;
                            contador++;
                            break;
                        }
                    } else if (aux.siguiente == null) {//------------->insertarEnPagina al final
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        aux.hijoDer = null;
                        contador++;
                        break;
                    }
                }
                aux = aux.siguiente;
            }

        }
    }

    public void eliminarEnPagina(){
        
    }
    public void imprimir(){
        NodoB aux=this.primero;
        while(aux.siguiente!=null){
            System.out.println(aux.valor + ", ");
            aux=aux.siguiente;
        }
    }

}
