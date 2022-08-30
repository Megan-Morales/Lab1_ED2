/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arbolB;

import estructuras.linkedlist.LinkedList;

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
    
    //MÉTODOS DE INSERCIÓN.
    public void insertarEnArbol(E valor) {
        NodoB nodo = new NodoB(valor);
        if (raiz == null) { 
            raiz = new Pagina();   //Si mi arbol está vacio, creo una nueva pagina
            raiz.insertarEnPagina(nodo);  //insertar el nodo en la pagina
        } else {
            NodoB obj = insertar_En_Pagina(nodo, raiz);
            if (obj != null) {
                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
                raiz = new Pagina();
                raiz.insertarEnPagina(obj);
                raiz.hoja = false;
            }
        }
    }

    private NodoB insertar_En_Pagina(NodoB nodoNuevo, Pagina pagina) {
        if (pagina.hoja) {
            //Esta parte es para insertarEnArbol el nodo en la página que sea hoja, de acuerdo al orden que debería llevar.
            pagina.insertarEnPagina(nodoNuevo);
            //Este es un if-else que es la parte que compara si se ha alcanzado el máximo de elementos en la hoja.
            return (pagina.contador == orden_arbol) ? dividir(pagina) : null; //operador ternario
        } else {
            //Si no es una hoja la página
            /*
                Entonces hay que recorrer el árbol por medio de sus páginas 
                y en cada página recorrer el nodo
                correspondiente viendo si es mayor o menor el nodo de entrada
             */
            NodoB nodoActual = pagina.primero;
            do {
                if (nodoNuevo.valor.compareTo(nodoActual.valor) == 0) { //Si tiene le mismo valor, se inserta en una lista enlazada
                    if(nodoActual.cabeza == false ){
                        nodoActual.cabeza = true;
                    }
                    nodoActual.listaRepetidos.insertElement_AtEnding(nodoNuevo.valor);
                    return null;
                } else if (nodoNuevo.valor.compareTo(nodoActual.valor) < 0) { //si es menor te tienes que desplazar a la página hijoIzq del nodoActual recorrido.
                    NodoB obj = insertar_En_Pagina(nodoNuevo, nodoActual.hijoIzq);
                    return validar_Division(obj, pagina);
                } else if (nodoActual.siguiente == null) {
                    NodoB obj = insertar_En_Pagina(nodoNuevo, nodoActual.hijoDer);
                    return validar_Division(obj, pagina);
                }
                nodoActual = (NodoB) nodoActual.siguiente;
            } while (nodoActual != null);
        }
        return null;
    }

    /**
     * Método validar si no se debe dividir aún más los nodos.
     *
     * @param obj
     * @param pagina
     * @return
     */
    private NodoB validar_Division(NodoB obj, Pagina pagina) { // Método validar si no se debe dividir aún más los nodos.
        if (obj instanceof NodoB) {
            pagina.insertarEnPagina((NodoB) obj);
            if (pagina.contador == orden_arbol) {
                return dividir(pagina);
            }
        }
        return null;
    }

    /**
     * Este método divide la página recursivamente.
     *
     * @param rama
     * @return
     */
    private NodoB dividir(Pagina pagina) {
        E valorNodoDivisor = null;
        NodoB<E> temp, nodoGenerado;
        NodoB<E> nodoActual = pagina.primero;
        Pagina rderecha = new Pagina();
        Pagina rizquierda = new Pagina();

        int cont = 0;
        while (nodoActual != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) { // Para los nodos que se van a la izquierda.
                temp = new NodoB(nodoActual.valor);
                temp.hijoIzq = nodoActual.hijoIzq;
                if (cont == 2) {
                    temp.hijoDer = nodoActual.siguiente.hijoIzq;
                } else {
                    temp.hijoDer = nodoActual.hijoDer; //este podría ser null
                }
                //si la pagina posee hijos quiere decir que no es una hoja
                if (temp.hijoDer != null && temp.hijoIzq != null) {
                    rizquierda.hoja = false;
                }
                rizquierda.insertarEnPagina(temp);

            } else if (cont == 3) {
                valorNodoDivisor = nodoActual.valor;
            } else { // Para los nodos que se van a la derecha.
                temp = new NodoB(nodoActual.valor, nodoActual.hijoIzq, nodoActual.hijoDer);
                //si la rama posee ramas deja de ser hoja
                if (temp.hijoDer != null && temp.hijoIzq != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertarEnPagina(temp);
            }
            nodoActual = nodoActual.siguiente;
        }
        nodoGenerado = new NodoB(valorNodoDivisor, rizquierda, rderecha);
        return nodoGenerado;
    }
   //==================================================MÉTODO DE ELIMINACIÓN ==================================================
    public void eliminarEnArbol(E valor){
        NodoB nodo = new NodoB(valor);
        
        if(this.raiz != null){
            
            eliminar_En_Pagina(nodo ,this.raiz);
        }
        else{
            
        }
        
    }
    
    public void eliminar_En_Pagina(NodoB nodoEliminar, Pagina pagina ){
        
        
        
    }
   //==================================================MÉTODOS DE RECORRIDOS==================================================
    /**
     * Parte 1) Método para convertir a una LinkedList mi árbol por medio del recorrido de amplitud.
     */
    public LinkedList<E> getLinkedList_RecorridoAmplitud(){
        LinkedList<E> listaValores_E =  new LinkedList<>();
        getLinkedList_RecorridoAmplitud(raiz, listaValores_E);
        return listaValores_E;
    }
    
    /**
     * Parte 2) Método para convertir a una LinkedList mi árbol por medio del recorrido de amplitud.
     * Recordar que este es un método iterativo que se acompaña de una cola.
     */
    private void getLinkedList_RecorridoAmplitud(Pagina root,  LinkedList<E> listaValores_E){
        if (root != null) {
            LinkedList<Pagina> colaPaginas = new LinkedList<>();
            colaPaginas.insertElement_AtEnding(raiz);
            Pagina paginaActual = null;
            while (colaPaginas.getlength() != 0) {
                paginaActual = colaPaginas.extractElement_AtBeggining().getValor();
                //Recorremos todos los nodos de la pagina actual y encolamos las paginas de cada nodo.
                NodoB<E> nodoActual = paginaActual.primero;
                while (nodoActual != null) {
                    listaValores_E.insertElement_AtEnding(nodoActual.valor);
                    if (nodoActual.hijoIzq != null) colaPaginas.insertElement_AtEnding(nodoActual.hijoIzq);
                    if (nodoActual.hijoDer != null) colaPaginas.insertElement_AtEnding(nodoActual.hijoDer);
                    nodoActual = nodoActual.siguiente;
                }
            }
        }
    }
    
    //==================================================MÉTODOS DE BÚSQUEDA==================================================

    /**
     * Nota: recordar que este método me devuelve la lista de posibles valores repetidos 
     * o una lista con un único elemento sino existen valores repetidos.
     * @param valorBuscado
     * @return
     */
    
    public LinkedList<E> getValorNodoB_by_Name(E valorBuscado) {
        return getValorNodo_by_Name(raiz, valorBuscado);
    }

    private LinkedList<E> getValorNodo_by_Name(Pagina paginaActual, E valorBuscado) {
        if (paginaActual != null) {
            //recorrer los hijos de cada clave
            NodoB<E> nodoActual = paginaActual.primero;
            while (nodoActual != null) {
                if (valorBuscado.compareTo(nodoActual.valor) == 0) {
                    LinkedList<E> listaValoresNodo = new LinkedList<>(); // creo mi lista
                    // verifico si mi nodo es una cabeza o sea si tiene una lista y la recorre
                    listaValoresNodo.insertElement_AtEnding(nodoActual.valor);
                    Object[] listaRepetidos = nodoActual.listaRepetidos.getArrayfromLinkedList();// todo hereda de object, para iterar utilizamos el getArrayfromLinkedList()
                    for (int i = 0; i < listaRepetidos.length; i++) {
                        E repetido = (E)listaRepetidos[i]; //hacemos el casteo correspondiente
                        listaValoresNodo.insertElement_AtEnding(repetido); //insertamos el repetido en la lista de repetidos.
                    }
                    return listaValoresNodo;
                } else if (valorBuscado.compareTo(nodoActual.valor) < 0) { // Si el valor buscado es menor al del nodo actual.
                    return getValorNodo_by_Name(nodoActual.hijoIzq, valorBuscado);
                } else if (nodoActual.siguiente == null) { //Si llego al último nodo ahí si debería irse por la derecha.
                    return getValorNodo_by_Name(nodoActual.hijoDer, valorBuscado);
                }
                nodoActual = nodoActual.siguiente;
            }
        }
        return null;
    }
  
}
